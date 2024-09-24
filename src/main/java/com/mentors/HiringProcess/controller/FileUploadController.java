 package com.mentors.HiringProcess.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mentors.HiringProcess.dto.ClientDto;
import com.mentors.HiringProcess.model.FileUpload;
import com.mentors.HiringProcess.repository.FileUploadRepository;
import com.mentors.HiringProcess.service.FileUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;



@RestController
@RequestMapping(value = "/fileupload")
@CrossOrigin
public class FileUploadController {
	
	@Autowired
    private FileUploadService fileUploadService;
	
	@Autowired
	private FileUploadRepository fileUploadRepository;
	
    @PostMapping("/")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Create FileUpload entity
            FileUpload fileContent = new FileUpload();
            fileContent.setFileName(file.getOriginalFilename());
            fileContent.setCreatedTimestamp(LocalDateTime.now());

            // Convert MultipartFile to Blob
            Blob content = new SerialBlob(file.getBytes());
            //fileContent.setContent(content);

            // Save the entity
            fileUploadRepository.save(fileContent);
            
            // Save the file to the local system
            saveFileToLocal(file);

            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }

    private void saveFileToLocal(MultipartFile file) throws IOException {
        // Define the primary and secondary paths where you want to save the file
        String primaryPath = "C:/fileupload-files/";
        String secondaryPath = "C:/fileupload1-files/";

        // Check if the primary directory exists
        File primaryDirectory = new File(primaryPath);
        String savePath;

        if (primaryDirectory.exists()) {
            // If primary directory exists, save to primary directory
            savePath = primaryPath + file.getOriginalFilename();
        } else {
            // If primary directory does not exist, create secondary directory and save to it
            File secondaryDirectory = new File(secondaryPath);
            if (!secondaryDirectory.exists()) {
                secondaryDirectory.mkdirs();
            }
            savePath = secondaryPath + file.getOriginalFilename();
        }

        // Write the file to the determined path
        try (FileOutputStream fos = new FileOutputStream(savePath)) {
            fos.write(file.getBytes());
        }
    }
    
    
    @GetMapping("/all")
    public List<FileUpload> getAllFiles() {
        return fileUploadRepository.findAll();
    }
    
    @GetMapping("/resumeslistwithpagination")
	public Page<FileUpload> getAllResumesWithPagination(@RequestParam int page, @RequestParam int size) {
	    //Pageable pageable = PageRequest.of(page, size);
    	Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdTimestamp"));
	    return fileUploadService.getAllResumesWithPagination(pageable);
	}
    
    //search for 
    @GetMapping("/searchpage")
	public Page<FileUpload> getAllResumes(@RequestParam int page, @RequestParam int size,
	        @RequestParam String code) {
	    //Pageable pageable = PageRequest.of(page, size);
	    Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdTimestamp"));
	    return fileUploadService.getAllResumes(pageable,code);
	}
	
    
    
    //View Api For Localstorage Resumes
//    @GetMapping("/{fileName}")
//    public ResponseEntity<?> downloadFile(@PathVariable String fileName) {
//        try {
//            Path filePath = fileUploadService.loadFileAsResource(fileName);
//            Resource resource = new UrlResource(filePath.toUri());
//            String contentType = Files.probeContentType(filePath);
//
//            return ResponseEntity.ok()
//                    .contentType(MediaType.parseMediaType(contentType))
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                    .body(resource);
//
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("File not found or not readable: " + fileName);
//        } catch (MalformedURLException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error occurred while processing the file URL.");
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Could not determine file type.");
//        }
//    }
    
    
    @GetMapping("/{fileName}")
    public ResponseEntity<?> viewFileContent(@PathVariable String fileName) {
        try {
            Path filePath = fileUploadService.loadFileAsResource(fileName);
            Resource resource = new UrlResource(filePath.toUri());
            String contentType = Files.probeContentType(filePath);

            // If contentType couldn't be determined, default to plain text
            if (contentType == null) {
                contentType = "text/plain";
            }

            // Return the file content to be displayed inline in the browser
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("File not found or not readable: " + fileName);
        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while processing the file URL.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Could not determine file type.");
        }
    }

    
    
    
//    @GetMapping("/view/{fileName}")
//    public ResponseEntity<byte[]> viewPDF(@PathVariable String fileName) {
//        try {
//            File file = new File("C:/fileupload-files1" + fileName);
//            byte[] pdfBytes = Files.readAllBytes(file.toPath());
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_PDF);
//            headers.setContentDispositionFormData(fileName, fileName);
//
//            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    
    @GetMapping("/view/{fileName}")

    public ResponseEntity<byte[]> viewFile(@PathVariable String fileName) {

        try {

            // Define the correct path to your files

            String filePath = "C:/fileupload1-files/" + fileName;

            File file = new File(filePath);

            

            // Check if the file exists and is readable

            if (!file.exists() || !file.isFile()) {

                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }

 

            // Determine content type

            String contentType = Files.probeContentType(file.toPath());

            if (contentType == null) {

                contentType = "application/octet-stream"; // Fallback content type

            }

 

            // Read the file bytes

            byte[] fileBytes = Files.readAllBytes(file.toPath());

 

            // Set headers

            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.parseMediaType(contentType));

 

            // No content disposition header means the file will be displayed inline

            return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);

        } catch (IOException e) {

            e.printStackTrace();

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
	
	

}

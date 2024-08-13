 package com.mentors.HiringProcess.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
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
@CrossOrigin(origins = "*")
public class FileUploadController {
	
	@Autowired
    private FileUploadService fileUploadService;
	
	@Autowired
	private FileUploadRepository fileUploadRepository;
	

//	@PostMapping("/")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        try {
//            // Create FileUpload entity
//            FileUpload fileContent = new FileUpload();
//            fileContent.setFileName(file.getOriginalFilename());
//
//            // Convert MultipartFile to Blob
//            Blob content = new SerialBlob(file.getBytes());
//            fileContent.setContent(content);
//
//            // Save the entity
//            fileUploadRepository.save(fileContent);
//            
//         // Save the file to the local system
//            saveFileToLocal(file);
//
//            return ResponseEntity.ok("File uploaded successfully");
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
//        }
//    }
//	
//	private void saveFileToLocal(MultipartFile file) throws IOException {
//        // Define the path where you want to save the file
//        String localPath = "E:/fileupload-files/" + file.getOriginalFilename(); // Change the path as needed
//        String localPath1 = "";
//
//        // Create the directory if it doesn't exist
//        File directory = new File("E:/fileupload1-files/");
//        if (!directory.exists()) {
//            directory.mkdirs();
//            localPath1 = "E:/fileupload1-files/" + file.getOriginalFilename(); // Change the path as needed
//        }
//
//        // Write the file to the local system
//        if(localPath!=null) {
//        try (FileOutputStream fos = new FileOutputStream(localPath)) {
//            fos.write(file.getBytes());
//        }
//        }
//        try (FileOutputStream fos = new FileOutputStream(localPath1)) {
//            fos.write(file.getBytes());
//        }
//    }
//	
	
	 
	
	@PostMapping("/")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Create FileUpload entity
            FileUpload fileContent = new FileUpload();
            fileContent.setFileName(file.getOriginalFilename());

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
	    Pageable pageable = PageRequest.of(page, size);
	    return fileUploadService.getAllResumesWithPagination(pageable);
	}
    
    //search for 
    @GetMapping("/searchpage")
	public Page<FileUpload> getAllResumes(@RequestParam int page, @RequestParam int size,
	        @RequestParam String code) {
	    Pageable pageable = PageRequest.of(page, size);
	    return fileUploadService.getAllResumes(pageable,code);
	}
	
    
    
    //View Api For Localstorage Resumes
    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        Path filePath = fileUploadService.loadFileAsResource(fileName);
        Resource resource;
        try {
            resource = new UrlResource(filePath.toUri());
            if (resource.exists() && resource.isReadable()) {
                String contentType = Files.probeContentType(filePath);

                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                throw new RuntimeException("File not found or not readable");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("File not found or not readable", e);
        } catch (IOException e) {
            throw new RuntimeException("Could not determine file type.", e);
        }
    }
    
    
    
    @GetMapping("/view/{fileName}")
    public ResponseEntity<byte[]> viewPDF(@PathVariable String fileName) {
        try {
            File file = new File("C:/fileupload-files1" + fileName);
            byte[] pdfBytes = Files.readAllBytes(file.toPath());

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData(fileName, fileName);

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	
	

}

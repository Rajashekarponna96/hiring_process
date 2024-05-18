 package com.mentors.HiringProcess.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mentors.HiringProcess.model.FileUpload;
import com.mentors.HiringProcess.repository.FileUploadRepository;



@RestController
@RequestMapping(value = "/fileupload")
@CrossOrigin(origins = "*")
public class FileUploadController {
	
	@Autowired
	private FileUploadRepository fileUploadRepository;
	

	@PostMapping("/")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Create FileUpload entity
            FileUpload fileContent = new FileUpload();
            fileContent.setFileName(file.getOriginalFilename());

            // Convert MultipartFile to Blob
            Blob content = new SerialBlob(file.getBytes());
            fileContent.setContent(content);

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
        // Define the path where you want to save the file
        String localPath = "E:/fileupload-files/" + file.getOriginalFilename(); // Change the path as needed

        // Create the directory if it doesn't exist
        File directory = new File("G:/fileupload-files/");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Write the file to the local system
        try (FileOutputStream fos = new FileOutputStream(localPath)) {
            fos.write(file.getBytes());
        }
    }
	
	
	
	

	
	

}

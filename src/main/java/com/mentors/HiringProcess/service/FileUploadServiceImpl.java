package com.mentors.HiringProcess.service;

import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;

import com.mentors.HiringProcess.builder.FileUploadBuilder;
import com.mentors.HiringProcess.model.Client;
import com.mentors.HiringProcess.model.FileUpload;
import com.mentors.HiringProcess.repository.ClientRepository;
import com.mentors.HiringProcess.repository.FileUploadRepository;
import com.mentors.HiringProcess.specification.ClientSprecifications;
import com.mentors.HiringProcess.specification.FileUploadSpecification;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
@Transactional
public class FileUploadServiceImpl  implements FileUploadService{
	
	@Autowired
    private FileUploadRepository fileUploadRepository;

    private final Path fileStorageLocation;
    
    @Autowired
    private FileUploadBuilder fileUploadBuilder;

    public FileUploadServiceImpl() {
        this.fileStorageLocation = Paths.get("C:/fileupload1-files/")
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public Path loadFileAsResource(String fileName) {
        System.out.println("File name is ----------" + fileName);
        Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
        
        if (Files.exists(filePath) && Files.isReadable(filePath)) {
            return filePath;
        } else {
            throw new RuntimeException("File not found or not readable: " + fileName);
        }
    }

    @Override
    public Page<FileUpload> getAllResumesWithPagination(Pageable pageable) {
        return fileUploadRepository.findAll(pageable);
    }

    @Override
    public Page<FileUpload> getAllResumes(Pageable pageable, String code) {
    	Specification<FileUpload> spec = Specification.where(null); // Start with an empty specification

        if (code != null && !code.isEmpty()) {
            spec = spec.and(FileUploadSpecification.hasFields(code));
        }

        Page<FileUpload> fileUploadPage = fileUploadRepository.findAll(spec, pageable);
        return fileUploadPage.map(fileUploadBuilder::toModel);
    }



}

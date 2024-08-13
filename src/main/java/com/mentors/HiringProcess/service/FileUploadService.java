package com.mentors.HiringProcess.service;
import java.nio.file.Path;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mentors.HiringProcess.dto.ClientDto;
import com.mentors.HiringProcess.model.FileUpload;
public interface FileUploadService {
	
	public Path loadFileAsResource(String fileName);
	
	public Page<FileUpload> getAllResumesWithPagination(Pageable pageable);
	
	public Page<FileUpload> getAllResumes(Pageable pageable, String code);

}

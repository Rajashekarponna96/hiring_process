package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.model.FileUpload;
@Component
public class FileUploadBuilder {
	
	public FileUpload toModel(FileUpload fileupload) {

		FileUpload department = new FileUpload();
		department.setId(fileupload.getId());
		department.setFileName(fileupload.getFileName());	
		return department;
	}

	
	
}

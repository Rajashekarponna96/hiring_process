package com.mentors.HiringProcess.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.FileUpload;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long>{

	FileUpload save(FileUpload fileContent);
	
	

}

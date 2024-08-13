package com.mentors.HiringProcess.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.Client;
import com.mentors.HiringProcess.model.FileUpload;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long>{

	FileUpload save(FileUpload fileContent);


	Page<FileUpload> findAll(Specification<FileUpload> spec, Pageable pageable);
	

}

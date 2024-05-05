package com.mentors.HiringProcess.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mentors.HiringProcess.model.EmailTemplate;
import com.mentors.HiringProcess.model.Vendor;


public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long>{


	EmailTemplate findByTitle(String title);

	Page<EmailTemplate> findAll(Specification<EmailTemplate> spec, Pageable pageable);
	

}

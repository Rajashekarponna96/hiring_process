package com.mentors.HiringProcess.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.EmailTemplateDto;

public interface EmailTemplateServiceI {

	void addCandidateEmail(EmailTemplateDto candidateEmailDto);

	List<EmailTemplateDto> findAll();

	void update(Long id, EmailTemplateDto candidateEmailDto);

	void delete(Long id);

	EmailTemplateDto getSubjectAndBodyByTitle(String title);
	
	Page<EmailTemplateDto> getAllEmailsWithPagination(Pageable pageable);

	Page<EmailTemplateDto> getAllTemplates(Pageable pageable, String code);

	

}

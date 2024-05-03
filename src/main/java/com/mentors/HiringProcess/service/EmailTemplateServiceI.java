package com.mentors.HiringProcess.service;

import java.util.List;

import com.mentors.HiringProcess.dto.EmailTemplateDto;

public interface EmailTemplateServiceI {

	void addCandidateEmail(EmailTemplateDto candidateEmailDto);

	List<EmailTemplateDto> findAll();

	void update(Long id, EmailTemplateDto candidateEmailDto);

	void delete(Long id);

	EmailTemplateDto getSubjectAndBodyByTitle(String title);

	

}

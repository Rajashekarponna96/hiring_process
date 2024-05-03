package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.EmailTemplateDto;
import com.mentors.HiringProcess.model.EmailTemplate;


@Component
public class EmailTemplateBuilder {
	
	public EmailTemplate toModel(EmailTemplateDto candidateEmailDto) {

		EmailTemplate candidateEmail = new EmailTemplate();
		candidateEmail.setId(candidateEmailDto.getId());
		candidateEmail.setSubject(candidateEmailDto.getSubject());
		candidateEmail.setBody(candidateEmailDto.getBody());
		candidateEmail.setTitle(candidateEmailDto.getTitle());
		return candidateEmail;
	}

	
	public EmailTemplateDto toDto(EmailTemplate candidateEmail) {
		EmailTemplateDto candidateEmailDto = new EmailTemplateDto();
		candidateEmailDto.setId(candidateEmail.getId());
		candidateEmailDto.setSubject(candidateEmail.getSubject());
		candidateEmailDto.setBody(candidateEmail.getBody());
		candidateEmailDto.setTitle(candidateEmail.getTitle());
		return candidateEmailDto;
}

}

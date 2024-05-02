package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.CandidateEmailDto;
import com.mentors.HiringProcess.model.CandidateEmail;


@Component
public class CandidateEmailBuilder {
	
	public CandidateEmail toModel(CandidateEmailDto candidateEmailDto) {

		CandidateEmail candidateEmail = new CandidateEmail();
		candidateEmail.setId(candidateEmailDto.getId());
		candidateEmail.setSubject(candidateEmailDto.getSubject());
		candidateEmail.setBody(candidateEmailDto.getBody());
		candidateEmail.setTitle(candidateEmailDto.getTitle());
		return candidateEmail;
	}

	
	public CandidateEmailDto toDto(CandidateEmail candidateEmail) {
		CandidateEmailDto candidateEmailDto = new CandidateEmailDto();
		candidateEmailDto.setId(candidateEmail.getId());
		candidateEmailDto.setSubject(candidateEmail.getSubject());
		candidateEmailDto.setBody(candidateEmail.getBody());
		candidateEmailDto.setTitle(candidateEmail.getTitle());
		return candidateEmailDto;
}

}

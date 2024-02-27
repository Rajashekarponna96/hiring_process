package com.mentors.HiringProcess.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.RecruiterDto;
import com.mentors.HiringProcess.model.Recruiter;

@Component
public class RecruiterBuilder {
	
	
	@Autowired
	private UserAccoutBuilder userAccoutBuilder;
	
	
	
	
	public Recruiter toModel(RecruiterDto recruiterDto) {

		Recruiter recruiter = new Recruiter();
		recruiter.setId(recruiterDto.getId());
		recruiter.setFirstName(recruiterDto.getFirstName());
		recruiter.setLastName(recruiterDto.getLastName());
		recruiter.setEmail(recruiterDto.getEmail());
		recruiter.setMobile(recruiterDto.getMobile());
		recruiter.setUserAccout(userAccoutBuilder.toModel(recruiterDto.getUserAccout()));
		
		
		return recruiter;
	}

	
	public RecruiterDto toDto(Recruiter recruiter) {
		RecruiterDto recruiterdto = new RecruiterDto();
		recruiterdto.setId(recruiter.getId());
		recruiterdto.setFirstName(recruiter.getFirstName());
		recruiterdto.setLastName(recruiter.getLastName());
		recruiterdto.setEmail(recruiter.getEmail());
		recruiterdto.setMobile(recruiter.getMobile());
		recruiterdto.setUserAccout(userAccoutBuilder.toDto(recruiter.getUserAccout()));
		return recruiterdto;
}

}

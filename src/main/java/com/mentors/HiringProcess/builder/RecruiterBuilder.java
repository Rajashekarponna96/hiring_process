package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.RecruiterDto;
import com.mentors.HiringProcess.model.Recruiter;

@Component
public class RecruiterBuilder {
	
	private UserAccoutBuilder userAccoutBuilder;
	
	 public RecruiterBuilder() {
	        this.userAccoutBuilder = new UserAccoutBuilder();
	 }
	
	
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
		recruiterdto.setFirstName(recruiter.getFirstName());
		recruiterdto.setLastName(recruiter.getLastName());
		recruiterdto.setEmail(recruiter.getEmail());
		recruiterdto.setMobile(recruiter.getMobile());
		recruiterdto.setUserAccout(userAccoutBuilder.toDto(recruiter.getUserAccout()));
		return recruiterdto;
}

}

package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.ExperienceDto;
import com.mentors.HiringProcess.model.Experience;
@Component
public class ExperienceBuilder {
	
	public Experience toModel(ExperienceDto experienceDto) {

		Experience experience = new Experience();
		experience.setId(experienceDto.getId());
		experience.setCompany(experienceDto.getCompany());
		experience.setJobTitle(experienceDto.getJobTitle());
		experience.setCurrentlyWokring(experienceDto.isCurrentlyWokring());
		experience.setDateOfJoining(experienceDto.getDateOfJoining());
		experience.setDateOfRelieving(experienceDto.getDateOfRelieving());
		experience.setLocation(experienceDto.getLocation());
		
		return experience;
	}

	
	public ExperienceDto toDto(Experience experience) {
		ExperienceDto ExperienceDto = new ExperienceDto();
		ExperienceDto.setCompany(experience.getCompany());
		ExperienceDto.setJobTitle(experience.getJobTitle());
		ExperienceDto.setCurrentlyWokring(experience.isCurrentlyWokring());
		ExperienceDto.setDateOfJoining(experience.getDateOfJoining());
		ExperienceDto.setDateOfRelieving(experience.getDateOfRelieving());
		ExperienceDto.setLocation(experience.getLocation());
		return ExperienceDto;
}

}

package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.EducationDto;
import com.mentors.HiringProcess.model.Education;

@Component
public class EducationBuilder {
	
	public Education toModel(EducationDto educationDto) {

		Education education = new Education();
		education.setId(educationDto.getId());
		education.setCourse(educationDto.getCourse());
		education.setBranch(educationDto.getBranch());
		education.setStartOfCourse(educationDto.getStartOfCourse());
		education.setEndOfCourse(educationDto.getEndOfCourse());
		education.setCollege(educationDto.getCollege());
		education.setLocation(educationDto.getLocation());
		
		return education;
	}

	
	public EducationDto toDto(Education education) {
		EducationDto educationDto = new EducationDto();
		educationDto.setCourse(education.getCourse());
		educationDto.setBranch(education.getBranch());
		educationDto.setStartOfCourse(education.getStartOfCourse());
		educationDto.setEndOfCourse(education.getEndOfCourse());
		educationDto.setCollege(education.getCollege());
		educationDto.setLocation(education.getLocation());
		
		return educationDto;
}

}

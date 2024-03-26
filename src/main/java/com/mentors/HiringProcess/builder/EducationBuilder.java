package com.mentors.HiringProcess.builder;

import java.util.ArrayList;
import java.util.List;

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
		educationDto.setId(education.getId());
		educationDto.setCourse(education.getCourse());
		educationDto.setBranch(education.getBranch());
		educationDto.setStartOfCourse(education.getStartOfCourse());
		educationDto.setEndOfCourse(education.getEndOfCourse());
		educationDto.setCollege(education.getCollege());
		educationDto.setLocation(education.getLocation());

		return educationDto;
	}
	
	
	public List<EducationDto> toDtoList(List<Education> list){
		List<EducationDto> dtos = new ArrayList<>();
	    for (Education edu : list) {
	    	dtos.add(toDto(edu));
	    }
	    return dtos;
	}
	
	
	public List<Education> toModelList(List<EducationDto> dtos){
		 List<Education> models = new ArrayList<>();
		 if(dtos!=null) {
		    for (EducationDto dto : dtos) {
		    models.add(toModel(dto));
		    }
		 }
		    
		 return models;
		    		
	}

}

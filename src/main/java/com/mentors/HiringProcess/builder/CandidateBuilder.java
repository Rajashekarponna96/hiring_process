package com.mentors.HiringProcess.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.EducationDto;
import com.mentors.HiringProcess.dto.ExperienceDto;
import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.Education;
import com.mentors.HiringProcess.model.Experience;
@Component
public class CandidateBuilder {
	@Autowired
	private SourceBuilder sourceBuilder;

	@Autowired
	private LocationBuilder locationBuilder;
	
	@Autowired
	private  CurrencyTypeBuilder currencyTypeBuilder;

	private TalentPoolBuilder talentPoolBuilder;
	
	private JobBuilder jobBuilder;
	
    public CandidateBuilder() {
        this.sourceBuilder = new SourceBuilder();
        this.locationBuilder=new LocationBuilder();
        this.currencyTypeBuilder=new CurrencyTypeBuilder();
        this.talentPoolBuilder=new TalentPoolBuilder();
        this.jobBuilder=new JobBuilder();
    }
	
	public Candidate toModel(CandidateDto candidateDto) {

		Candidate candidate = new Candidate();
		SourceBuilder sourceBuilder=new SourceBuilder();
		candidate.setId(candidateDto.getId());
		candidate.setFirstName(candidateDto.getFirstName());
		candidate.setLastName(candidateDto.getLastName());
		candidate.setMiddleName(candidateDto.getMiddleName());
		candidate.setEmail(candidateDto.getEmail());
		candidate.setMobile(candidateDto.getMobile());
		candidate.setSource(sourceBuilder.toModel(candidateDto.getSource()));
		candidate.setCurrent(locationBuilder.toModel(candidateDto.getCurrent()));
		candidate.setAvialToJoin(candidateDto.getAvialToJoin());
		candidate.setPreferred(locationBuilder.toModel(candidateDto.getPreferred()));
		candidate.setCurrentSalary(candidateDto.getCurrentSalary());
		candidate.setExpectedSalary(candidateDto.getExpectedSalary());
		candidate.setCurrency(currencyTypeBuilder.toModel(candidateDto.getCurrency()));
		candidate.setGender(candidateDto.getGender());
		candidate.setDateOfBirth(candidateDto.getDateOfBirth());
		candidate.setTalentPool(talentPoolBuilder.toModel(candidateDto.getTalentPool()));
		candidate.setJob(jobBuilder.toModel(candidateDto.getJob()));
		candidate.setSkills(candidateDto.getSkills());
		return candidate;
	}
	
	public CandidateDto toDto(Candidate candidate) {
		CandidateDto candidatedto = new CandidateDto();
		candidatedto.setFirstName(candidate.getFirstName());
		candidatedto.setLastName(candidate.getLastName());
		candidatedto.setMiddleName(candidate.getMiddleName());
		candidatedto.setEmail(candidate.getEmail());
		candidatedto.setMobile(candidate.getMobile());
		candidatedto.setSource(sourceBuilder.toDto(candidate.getSource()));
		candidatedto.setCurrent(locationBuilder.toDto(candidate.getCurrent()));
		candidatedto.setAvialToJoin(candidate.getAvialToJoin());
		candidatedto.setPreferred(locationBuilder.toDto(candidate.getPreferred()));
		candidatedto.setCurrentSalary(candidate.getCurrentSalary());
		candidatedto.setExpectedSalary(candidate.getExpectedSalary());
		candidatedto.setCurrency(currencyTypeBuilder.toDto(candidate.getCurrency()));
		candidatedto.setGender(candidate.getGender());
		candidatedto.setDateOfBirth(candidate.getDateOfBirth());
		candidatedto.setTalentPool(talentPoolBuilder.toDto(candidate.getTalentPool()));
		candidatedto.setJob(jobBuilder.toDto(candidate.getJob()));
		candidatedto.setSkills(candidate.getSkills());
		
		List<ExperienceDto> experienceDtos = new ArrayList<>();
	    for (Experience experience : candidate.getExperiences()) {
	    	ExperienceDto experienceDto = new ExperienceDto();
	    	experienceDto.setId(candidate.getId());
	    	experienceDtos.add(experienceDto);
	    }
	    candidatedto.setExperiences(experienceDtos);
	    
	    List<EducationDto> educationDtos = new ArrayList<>();
	    for (Education education : candidate.getEducations()) {
	    	EducationDto educationDto = new EducationDto();
	    	educationDto.setId(education.getId());
	    	educationDtos.add(educationDto);
	    }
	    candidatedto.setEducations(educationDtos);
		
       return candidatedto;
	}
}

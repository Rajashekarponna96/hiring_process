package com.mentors.HiringProcess.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.model.Candidate;
@Component
public class CandidateBuilder {
	@Autowired
	private SourceBuilder sourceBuilder;

	@Autowired
	private LocationBuilder locationBuilder;
	
	@Autowired
	private  CurrencyTypeBuilder currencyTypeBuilder;

	@Autowired
	private TalentPoolBuilder talentPoolBuilder;
	
	@Autowired
	private JobBuilder jobBuilder;
	
	
	@Autowired
	private ExperienceBuilder experienceBuilder;
	
	@Autowired
	private EducationBuilder educationBuilder;
	
	
	
   
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
		candidate.setStage(candidateDto.getStage());
		candidate.setEducations(educationBuilder.toModelList(candidateDto.getEducations()));
		candidate.setExperiences(experienceBuilder.toModelList(candidateDto.getExperiences()));
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
		candidatedto.setEducations(educationBuilder.toDtoList(candidate.getEducations()));
		candidatedto.setExperiences(experienceBuilder.toDtoList(candidate.getExperiences()));
		candidatedto.setStage(candidate.getStage());
		
	   
		
       return candidatedto;
	}
}

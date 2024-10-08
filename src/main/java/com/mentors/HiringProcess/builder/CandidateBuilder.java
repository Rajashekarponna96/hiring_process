package com.mentors.HiringProcess.builder;

import java.util.stream.Collectors;

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
	private CurrencyTypeBuilder currencyTypeBuilder;

	@Autowired
	private TalentPoolBuilder talentPoolBuilder;

	@Autowired
	private JobBuilder jobBuilder;
	
    @Autowired
	private UserAccoutBuilder userAccoutBuilder;
    
	@Autowired
	private ExperienceBuilder experienceBuilder;

	@Autowired
	private EducationBuilder educationBuilder;

	@Autowired
	private VendorBuilder vendorBuilder;
	


	public Candidate toModel(CandidateDto candidateDto) {
		
		if(candidateDto ==null) {
			return null;
		}

		Candidate candidate = new Candidate();
		SourceBuilder sourceBuilder = new SourceBuilder();
		candidate.setId(candidateDto.getId());
		candidate.setFirstName(candidateDto.getFirstName());
		candidate.setLastName(candidateDto.getLastName());
//		candidate.setMiddleName(candidateDto.getMiddleName());
		candidate.setEmail(candidateDto.getEmail());
		candidate.setMobile(candidateDto.getMobile());
		candidate.setAlterMobile(candidateDto.getAlterMobile());
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
		if (candidateDto.getJob() != null) {
	        candidate.setJob(jobBuilder.toModel(candidateDto.getJob()));
	    }
		candidate.setSkills(candidateDto.getSkills());
		candidate.setStage(candidateDto.getStage());
//		candidate.setCreatedBy(userAccoutBuilder.toModel(candidateDto.getCreatedBy()));
		candidate.setModifiedBy(userAccoutBuilder.toModel(candidateDto.getModifiedBy()));
		candidate.setCreatedTimestamp(candidateDto.getCreatedTimestamp());
		candidate.setModifiedTimestamp(candidateDto.getModifiedTimestamp());
		candidate.setEducations(educationBuilder.toModelList(candidateDto.getEducations()).stream()
				.peek(e -> e.setCandidate(candidate)).collect(Collectors.toList()));
		candidate.setExperiences(experienceBuilder.toModelList(candidateDto.getExperiences()).stream()
				.peek(e -> e.setCandidate(candidate)).collect(Collectors.toList()));
		candidate.setVendor(vendorBuilder.toModel(candidateDto.getVendor()));
		candidate.setUserAccout(userAccoutBuilder.toModel(candidateDto.getUserAccout()));
		candidate.setStatus(candidateDto.isStatus());
		candidate.setFileName(candidateDto.getFileName());
		candidate.setPrimarySkill(candidateDto.getPrimarySkill());
		return candidate;
	}

	public CandidateDto toDto(Candidate candidate) {
		CandidateDto candidatedto = new CandidateDto();
		candidatedto.setId(candidate.getId());
		candidatedto.setFirstName(candidate.getFirstName());
		candidatedto.setLastName(candidate.getLastName());
		candidatedto.setEmail(candidate.getEmail());
		candidatedto.setMobile(candidate.getMobile());
		candidatedto.setAlterMobile(candidate.getAlterMobile());
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
		if (candidate.getJob() != null) {
	        candidatedto.setJob(jobBuilder.toDto(candidate.getJob()));
	    }
		candidatedto.setSkills(candidate.getSkills());
		candidatedto.setEducations(educationBuilder.toDtoList(candidate.getEducations()));
		candidatedto.setExperiences(experienceBuilder.toDtoList(candidate.getExperiences()));
		candidatedto.setStage(candidate.getStage());
//		candidatedto.setCreatedBy(userAccoutBuilder.toDto(candidate.getCreatedBy()));
		candidatedto.setModifiedBy(userAccoutBuilder.toDto(candidate.getModifiedBy()));
		candidatedto.setCreatedTimestamp(candidate.getCreatedTimestamp());
		candidatedto.setModifiedTimestamp(candidate.getModifiedTimestamp());
		candidatedto.setVendor(vendorBuilder.toDto(candidate.getVendor()));
		candidatedto.setUserAccout(userAccoutBuilder.toDto(candidate.getUserAccout()));
		candidatedto.setStatus(candidate.isStatus());
		candidatedto.setFileName(candidate.getFileName());
		candidatedto.setPrimarySkill(candidate.getPrimarySkill());

		return candidatedto;
	}
}

package com.mentors.HiringProcess.dto;

import java.time.LocalDate;
import java.util.List;

import com.mentors.HiringProcess.model.CurrencyType;
import com.mentors.HiringProcess.model.Education;
import com.mentors.HiringProcess.model.Experience;
import com.mentors.HiringProcess.model.Gender;
import com.mentors.HiringProcess.model.HiringFlowType;
import com.mentors.HiringProcess.model.Job;
import com.mentors.HiringProcess.model.Location;
import com.mentors.HiringProcess.model.Source;
import com.mentors.HiringProcess.model.TalentPool;

public class CandidateDto {
	private Long id;

	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	private String email;
	
	private String mobile;
	
	private SourceDto source;
	
	private HiringFlowType stage;
	
	private LocationDto current;
	
	private Long avialToJoin;
	
	private LocationDto preferred;
	
	private Double currentSalary;
	
	private Double expectedSalary;
	
	private CurrencyTypeDto  currency;
	
	private Gender gender;
	
	private LocalDate dateOfBirth;
	
	private List<String> skills;
	
	private List<ExperienceDto> experiences;
	
	private List<EducationDto> educations;
	
	private TalentPoolDto talentPool;
	
	private JobDto job;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public SourceDto getSource() {
		return source;
	}

	public void setSource(SourceDto source) {
		this.source = source;
	}

	

	public HiringFlowType getStage() {
		return stage;
	}

	public void setStage(HiringFlowType stage) {
		this.stage = stage;
	}

	public LocationDto getCurrent() {
		return current;
	}

	public void setCurrent(LocationDto current) {
		this.current = current;
	}

	public Long getAvialToJoin() {
		return avialToJoin;
	}

	public void setAvialToJoin(Long avialToJoin) {
		this.avialToJoin = avialToJoin;
	}

	public LocationDto getPreferred() {
		return preferred;
	}

	public void setPreferred(LocationDto preferred) {
		this.preferred = preferred;
	}

	public Double getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(Double currentSalary) {
		this.currentSalary = currentSalary;
	}

	public Double getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(Double expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public CurrencyTypeDto getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyTypeDto currency) {
		this.currency = currency;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<ExperienceDto> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<ExperienceDto> experiences) {
		this.experiences = experiences;
	}

	public List<EducationDto> getEducations() {
		return educations;
	}

	public void setEducations(List<EducationDto> educations) {
		this.educations = educations;
	}

	public TalentPoolDto getTalentPool() {
		return talentPool;
	}

	public void setTalentPool(TalentPoolDto talentPool) {
		this.talentPool = talentPool;
	}

	public JobDto getJob() {
		return job;
	}

	public void setJob(JobDto job) {
		this.job = job;
	}

	
	public void validateREquiredAttibutes(CandidateDto candidateDto) {
		if(candidateDto.getFirstName()==null) {
			throw new RuntimeException("FirstName is Mandatory");
		}
		if(candidateDto.getLastName()==null) {
			throw new RuntimeException("LastName is Mandatory");
		}
		if(candidateDto.getMiddleName()==null) {
			throw new RuntimeException("MiddleName is Mandatory");
		}
		if(candidateDto.getMobile()==null) {
			throw new RuntimeException("Mobile is Mandatory");
		}
		if(candidateDto.getAvialToJoin()==null) {
			throw new RuntimeException("AvialToJoin is Mandatory");
		}
		if(candidateDto.getCurrentSalary()==null) {
			throw new RuntimeException("CurrentSalary is Mandatory");
		}
		if(candidateDto.getExpectedSalary()==null) {
			throw new RuntimeException("ExpectedSalary is Mandatory");
		}
	}

}

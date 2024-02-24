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
	
	private Source source;
	
	private HiringFlowType stage;
	
	private Location current;
	
	private Long avialToJoin;
	
	private Location preferred;
	
	private Double currentSalary;
	
	private Double expectedSalary;
	
	private CurrencyType  currency;
	
	private Gender gender;
	
	private LocalDate dateOfBirth;
	
	private List<String> skills;
	
	private List<Experience> experiences;
	
	private List<Education> educations;
	
	private TalentPool talentPool;
	
	private Job job;

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

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public HiringFlowType getStage() {
		return stage;
	}

	public void setStage(HiringFlowType stage) {
		this.stage = stage;
	}

	public Location getCurrent() {
		return current;
	}

	public void setCurrent(Location current) {
		this.current = current;
	}

	public Long getAvialToJoin() {
		return avialToJoin;
	}

	public void setAvialToJoin(Long avialToJoin) {
		this.avialToJoin = avialToJoin;
	}

	public Location getPreferred() {
		return preferred;
	}

	public void setPreferred(Location preferred) {
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

	public CurrencyType getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyType currency) {
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

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public TalentPool getTalentPool() {
		return talentPool;
	}

	public void setTalentPool(TalentPool talentPool) {
		this.talentPool = talentPool;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	

}

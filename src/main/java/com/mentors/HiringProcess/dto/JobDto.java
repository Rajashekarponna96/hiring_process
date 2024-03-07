package com.mentors.HiringProcess.dto;

import java.time.LocalDate;
import java.util.List;

import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.CurrencyType;
import com.mentors.HiringProcess.model.Department;
import com.mentors.HiringProcess.model.HiringFlow;
import com.mentors.HiringProcess.model.JobType;
import com.mentors.HiringProcess.model.Location;
import com.mentors.HiringProcess.model.Recruiter;

public class JobDto {
	
private Long id;
	
	private String title;
	
	private String description;
	
	private DepartmentDto department;
	
	private long openings;
	
	private LocalDate targetHireDate;
	
	private CurrencyTypeDto currney;
	
	private Double salaryMinimum;

	private Double salaryMaximum;
	
	private JobType type;
	
	private List<LocationDto> locations;
	
	private List<HiringFlowDto> flows;
	
	private Double experience;
	
	private List<CandidateDto> candidates;
	
	private RecruiterDto recruiters;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DepartmentDto getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}

	public long getOpenings() {
		return openings;
	}

	public void setOpenings(long openings) {
		this.openings = openings;
	}

	public LocalDate getTargetHireDate() {
		return targetHireDate;
	}

	public void setTargetHireDate(LocalDate targetHireDate) {
		this.targetHireDate = targetHireDate;
	}

	public CurrencyTypeDto getCurrney() {
		return currney;
	}

	public void setCurrney(CurrencyTypeDto currney) {
		this.currney = currney;
	}

	public Double getSalaryMinimum() {
		return salaryMinimum;
	}

	public void setSalaryMinimum(Double salaryMinimum) {
		this.salaryMinimum = salaryMinimum;
	}

	public Double getSalaryMaximum() {
		return salaryMaximum;
	}

	public void setSalaryMaximum(Double salaryMaximum) {
		this.salaryMaximum = salaryMaximum;
	}

	public JobType getType() {
		return type;
	}

	public void setType(JobType type) {
		this.type = type;
	}

	public List<LocationDto> getLocations() {
		return locations;
	}

	public void setLocations(List<LocationDto> locations) {
		this.locations = locations;
	}

	public List<HiringFlowDto> getFlows() {
		return flows;
	}

	public void setFlows(List<HiringFlowDto> flows) {
		this.flows = flows;
	}

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	public List<CandidateDto> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<CandidateDto> candidates) {
		this.candidates = candidates;
	}

	public RecruiterDto getRecruiters() {
		return recruiters;
	}

	public void setRecruiters(RecruiterDto recruiters) {
		this.recruiters = recruiters;
	}

	
	
}

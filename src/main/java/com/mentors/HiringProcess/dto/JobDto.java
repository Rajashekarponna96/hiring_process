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
	
	private Department department;
	
	private long openings;
	
	private LocalDate targetHireDate;
	
	private CurrencyType currney;
	
	private Double salaryMinimum;

	private Double salaryMaximum;
	
	private JobType type;
	
	private List<Location> locations;
	
	private List<HiringFlow> flows;
	
	private Double experience;
	
	private List<Candidate> candidates;
	
	private List<Recruiter> recruiters;

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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
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

	public CurrencyType getCurrney() {
		return currney;
	}

	public void setCurrney(CurrencyType currney) {
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

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public List<HiringFlow> getFlows() {
		return flows;
	}

	public void setFlows(List<HiringFlow> flows) {
		this.flows = flows;
	}

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public List<Recruiter> getRecruiters() {
		return recruiters;
	}

	public void setRecruiters(List<Recruiter> recruiters) {
		this.recruiters = recruiters;
	}
	
	

}

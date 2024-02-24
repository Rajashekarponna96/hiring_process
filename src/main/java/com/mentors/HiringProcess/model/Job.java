package com.mentors.HiringProcess.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="job")
public class Job implements Serializable {
	
	
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id", referencedColumnName = "id")
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
	@ManyToOne
	@JoinColumn(name="currencytype_id",referencedColumnName = "id")
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
	@Enumerated
	public JobType getType() {
		return type;
	}

	public void setType(JobType type) {
		this.type = type;
	}
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="location_id",referencedColumnName = "id")
	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="hiringflow_id",referencedColumnName = "id")
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
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="candidate_id",referencedColumnName = "id")
	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="recruiter_id",referencedColumnName = "id")
	public List<Recruiter> getRecruiters() {
		return recruiters;
	}

	public void setRecruiters(List<Recruiter> recruiters) {
		this.recruiters = recruiters;
	}
	
	

}
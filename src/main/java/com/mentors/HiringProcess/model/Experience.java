package com.mentors.HiringProcess.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="experience")
public class Experience implements Serializable{
	
	
	private Long id;
	
	private String company;
	
	private String jobTitle;
	
	private boolean currentlyWokring;
	
	private LocalDate dateOfJoining;
	
	private LocalDate dateOfRelieving;
	
	private String location;
	
	private Candidate candidate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public boolean isCurrentlyWokring() {
		return currentlyWokring;
	}

	public void setCurrentlyWokring(boolean currentlyWokring) {
		this.currentlyWokring = currentlyWokring;
	}
	
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	public LocalDate getDateOfRelieving() {
		return dateOfRelieving;
	}

	public void setDateOfRelieving(LocalDate dateOfRelieving) {
		this.dateOfRelieving = dateOfRelieving;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	@ManyToOne
    @JoinColumn(name = "candidate_id")
	public Candidate getCandidate() {
		return candidate;
	}
	
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	
	

}

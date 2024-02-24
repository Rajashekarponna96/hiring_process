package com.mentors.HiringProcess.dto;

import java.time.LocalDate;

public class ExperienceDto {
	
    private Long id;
	
	private String company;
	
	private String jobTitle;
	
	private boolean currentlyWokring;
	
	private LocalDate dateOfJoining;
	
	private LocalDate dateOfRelieving;
	
	private String location;

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
	
	

}

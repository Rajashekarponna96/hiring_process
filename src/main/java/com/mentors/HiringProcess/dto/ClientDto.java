package com.mentors.HiringProcess.dto;

import java.util.List;

import com.mentors.HiringProcess.model.Job;

public class ClientDto {
	
    private long id;
	
	private String companyName;
	
	private List<PocDto> pocs;
	
	private String location;
	
	private List<JobDto> jobs;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<PocDto> getPocs() {
		return pocs;
	}

	public void setPocs(List<PocDto> pocs) {
		this.pocs = pocs;
	}

	public List<JobDto> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobDto> jobs) {
		this.jobs = jobs;
	}

	
	
	

}

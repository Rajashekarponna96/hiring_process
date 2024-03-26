package com.mentors.HiringProcess.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="client")
public class Client implements Serializable{
	
	private long id;
	
	private String companyName;
	
	private List<Poc> pocs;
	
	private String location;
	
	private List<Job> job;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@JsonIgnore
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	public List<Poc> getPocs() {
		return pocs;
	}

	public void setPocs(List<Poc> pocs) {
		this.pocs = pocs;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
//	@JsonIgnore
//	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	public List<Job> getJob() {
		return job;
	}

	public void setJob(List<Job> job) {
		this.job = job;
	}
	
	

}

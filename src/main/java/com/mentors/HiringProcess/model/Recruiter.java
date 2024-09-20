package com.mentors.HiringProcess.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="recruiter")
public class Recruiter implements Serializable{
	
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobile;
	
	private UserAccout userAccout;
	
	private List<Job> job;
	
    private LocalDateTime createdTimestamp;
    
    private LocalDateTime modifiedTimestamp;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "useraccount_id", referencedColumnName = "id")
	public UserAccout getUserAccout() {
		return userAccout;
	}

	public void setUserAccout(UserAccout userAccout) {
		this.userAccout = userAccout;
	}

	public List<Job> getJob() {
		return job;
	}

	public void setJob(List<Job> job) {
		this.job = job;
	}
	
	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public LocalDateTime getModifiedTimestamp() {
		return modifiedTimestamp;
	}

	public void setModifiedTimestamp(LocalDateTime modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}
	
	
	
	
	
	

}

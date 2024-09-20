package com.mentors.HiringProcess.dto;

import java.time.LocalDateTime;

import com.mentors.HiringProcess.model.UserAccout;

public class RecruiterDto {
	
    private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobile;
	
	private UserAccoutDto userAccout;
	
    private LocalDateTime createdTimestamp;
    
    private LocalDateTime modifiedTimestamp;

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

	public UserAccoutDto getUserAccout() {
		return userAccout;
	}

	public void setUserAccout(UserAccoutDto userAccout) {
		this.userAccout = userAccout;
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

	public void validateRequiredAttibutes(RecruiterDto recruiterDto) {
		
		if(recruiterDto.getFirstName()==null) {
			throw new RuntimeException("FirstName is Mandatory");
		}
		if(recruiterDto.getLastName()==null) {
			throw new RuntimeException("LastName is Mandatory");
		}
		if(recruiterDto.getEmail()==null) {
			throw new RuntimeException("Email is Mandatory");
		}
		if(recruiterDto.getMobile()==null) {
			throw new RuntimeException("Mobile is Mandatory");
		}
		
	}

	

	
}

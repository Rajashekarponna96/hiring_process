package com.mentors.HiringProcess.dto.response;

import com.mentors.HiringProcess.model.UserAccout;

public class RecruiterResponseDto {
	
    private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobile;
	
	private UserAccout userAccout;

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

	public UserAccout getUserAccout() {
		return userAccout;
	}

	public void setUserAccout(UserAccout userAccout) {
		this.userAccout = userAccout;
	}
	

	
}

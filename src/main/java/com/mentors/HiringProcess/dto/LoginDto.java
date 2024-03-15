package com.mentors.HiringProcess.dto;

import com.mentors.HiringProcess.common.CommonException;
import com.mentors.HiringProcess.common.CommonExceptionMessage;

public class LoginDto {
	
    private String userName;
	
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void validateLoginRequired(LoginDto loginDto) {
		
		if (loginDto.password.isEmpty()) {
			throw CommonException.CreateException(CommonExceptionMessage.REQUIRED_ATTRIBUTE, "Password");
		}
	}
	
	

}

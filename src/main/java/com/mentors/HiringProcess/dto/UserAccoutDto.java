package com.mentors.HiringProcess.dto;

public class UserAccoutDto {
	
    private Long id;
	
	private String userName;
	
	private String password;
	
	private  boolean active;
	
	private RoleDto role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

	public void validateRequiredAttibutes(UserAccoutDto userAccoutDto) {
		if(userAccoutDto.getUserName()==null) {
			throw new RuntimeException("UserName is Mandatory");
		}
		if(userAccoutDto.getPassword()==null) {
			throw new RuntimeException("Password is Mandatory");
		}
		
	}


}

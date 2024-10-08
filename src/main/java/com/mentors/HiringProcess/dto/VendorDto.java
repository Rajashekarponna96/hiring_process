package com.mentors.HiringProcess.dto;

import java.time.LocalDateTime;

public class VendorDto {
	
    private long id;
	
	private String vendorName;
	
	private String location;	
	
    private String email;
	
	private String mobile;
	
	private UserAccoutDto userAccout;
	
    private LocalDateTime createdTimestamp;
    
    private LocalDateTime modifiedTimestamp;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public void validateRequiredAttibutes(VendorDto vendorDto) {
		if(vendorDto.getVendorName()!=null && vendorDto.getVendorName().isEmpty()) {
			throw  new RuntimeException("Vendor name is  Mandatory");
		}
		if(vendorDto.getLocation()!=null && vendorDto.getLocation().isEmpty()) {
			throw new RuntimeException("Location is Mandatory");
		}
	}

}

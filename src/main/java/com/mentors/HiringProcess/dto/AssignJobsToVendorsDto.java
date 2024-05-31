package com.mentors.HiringProcess.dto;

import java.util.List;

public class AssignJobsToVendorsDto {
	
	private List<Long> vendorIds;
    private List<Long> jobIds;
    
    
	public List<Long> getVendorIds() {
		return vendorIds;
	}
	public void setVendorIds(List<Long> vendorIds) {
		this.vendorIds = vendorIds;
	}
	public List<Long> getJobIds() {
		return jobIds;
	}
	public void setJobIds(List<Long> jobIds) {
		this.jobIds = jobIds;
	}
    
    

}

package com.mentors.HiringProcess.dto;

import java.util.List;

public class AssignJobsToRecruitersDto {

	private List<Long> recruiterIds;
    private List<Long> jobIds;
    
    
	public List<Long> getRecruiterIds() {
		return recruiterIds;
	}
	public void setRecruiterIds(List<Long> recruiterIds) {
		this.recruiterIds = recruiterIds;
	}
	public List<Long> getJobIds() {
		return jobIds;
	}
	public void setJobIds(List<Long> jobIds) {
		this.jobIds = jobIds;
	}
    
    
}

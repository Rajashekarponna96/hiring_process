package com.mentors.HiringProcess.dto;

import java.time.LocalDateTime;

import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.HiringFlowType;
import com.mentors.HiringProcess.model.UserAccout;

public class HiringFlowActivityDto {
	
    private Long id;
	
	private UserAccout userAccount;
	
	private LocalDateTime createdDate;
	
	private HiringFlowType hiringFlowType;
	
	private CandidateDto candidate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserAccout getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccout userAccount) {
		this.userAccount = userAccount;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public HiringFlowType getHiringFlowType() {
		return hiringFlowType;
	}

	public void setHiringFlowType(HiringFlowType hiringFlowType) {
		this.hiringFlowType = hiringFlowType;
	}

	public CandidateDto getCandidate() {
		return candidate;
	}

	public void setCandidate(CandidateDto candidate) {
		this.candidate = candidate;
	}
	
	
	
	

}

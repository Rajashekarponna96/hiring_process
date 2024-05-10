package com.mentors.HiringProcess.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "hiring_flow_activity")
public class HiringFlowActivity  implements Serializable{
	
	private Long id;
	
	private UserAccout userAccount;
	
	private LocalDateTime createdDate;
	
	private HiringFlowType hiringFlowType;
	
	private Candidate candidate;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="candidate_id")
	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	
	
	

}

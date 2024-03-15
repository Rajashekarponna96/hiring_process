package com.mentors.HiringProcess.dto;

import java.util.List;

import com.mentors.HiringProcess.model.Candidate;

public class TalentPoolDto {
	
    private Long id;
	
	private String name;
	
	
	private String description;
	
	private List<CandidateDto> candidates;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CandidateDto> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<CandidateDto> candidates) {
		this.candidates = candidates;
	}

	public void validateRequiredAttibutes(TalentPoolDto talentPoolDto) {
		
		if(talentPoolDto.getName()==null) {
			throw new RuntimeException("Name is Mandatory");
		}
		if(talentPoolDto.getDescription()==null) {
			throw new RuntimeException("Description is Mandatory");
		}
		
	}

	

	
}

package com.mentors.HiringProcess.dto.response;

import java.util.List;

import com.mentors.HiringProcess.model.Candidate;

public class TalentPoolResponseDto {
	
    private Long id;
	
	private String name;
	
	
	private String description;
	
	private List<Candidate> candidates;

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

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	
}

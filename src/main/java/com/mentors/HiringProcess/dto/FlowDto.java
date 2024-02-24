package com.mentors.HiringProcess.dto;

import java.util.List;

import com.mentors.HiringProcess.model.FlowStep;

public class FlowDto {
	
    private Long id;
	
	private String name;
	
	private List<FlowStep> steps;

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

	public List<FlowStep> getSteps() {
		return steps;
	}

	public void setSteps(List<FlowStep> steps) {
		this.steps = steps;
	}

	
}

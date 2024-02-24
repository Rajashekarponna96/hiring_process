package com.mentors.HiringProcess.dto;

import com.mentors.HiringProcess.model.HiringFlowType;

public class HiringFlowDto {
  
    private Long id;
	
	private HiringFlowType type;
	
	private String description;
	
	private FlowDto source;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	
	public HiringFlowType getType() {
		return type;
	}

	public void setType(HiringFlowType type) {
		this.type = type;
	}

	public FlowDto getSource() {
		return source;
	}

	public void setSource(FlowDto source) {
		this.source = source;
	}

	
	
}

package com.mentors.HiringProcess.dto.response;

import com.mentors.HiringProcess.model.Flow;
import com.mentors.HiringProcess.model.HiringFlowType;

public class HiringFlowResponseDto {
  
    private Long id;
	
	private HiringFlowType type;
	
	private String description;
	
	private Flow source;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HiringFlowType getType() {
		return type;
	}

	public void setType(HiringFlowType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Flow getSource() {
		return source;
	}

	public void setSource(Flow source) {
		this.source = source;
	}
	
	
}

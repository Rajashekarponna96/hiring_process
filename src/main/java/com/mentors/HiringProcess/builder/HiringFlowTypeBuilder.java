package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.HiringFlowTypeDto;
import com.mentors.HiringProcess.model.HiringFlowType;
@Component
public class HiringFlowTypeBuilder {

	// Sourced,Screening,Interview,Preboarding,Hired,Archived
	// Convert from HiringFlowType to HiringFlowTypeDto
	public static HiringFlowTypeDto toDto(HiringFlowType hiringFlowType) {
		HiringFlowTypeDto hiringFlowTypeDto = new HiringFlowTypeDto();
		hiringFlowTypeDto.setValue(hiringFlowType.name()); // Assuming HiringFlowTypeDto has a field 'value' to store
															// the enum value
		return hiringFlowTypeDto;
	}

	// Convert from HiringFlowTypeDto to HiringFlowType
	public static HiringFlowType fromDto(HiringFlowTypeDto hiringFlowTypeDto) {
		return HiringFlowType.valueOf(hiringFlowTypeDto.getValue()); // Assuming HiringFlowTypeDto has a field 'value'
																		// to store the enum value
	}
}

package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.FlowStepDto;
import com.mentors.HiringProcess.model.FlowStep;
@Component
public class FlowStepBuilder {
	
	public FlowStep toModel(FlowStepDto flowStepDto) {

		FlowStep flowStep = new FlowStep();
		flowStep.setId(flowStepDto.getId());
		flowStep.setName(flowStepDto.getName());
		flowStep.setCode(flowStepDto.getCode());
		
		return flowStep;
	}

	
	public FlowStepDto toDto(FlowStep flowStep) {
		FlowStepDto flowStepDto = new FlowStepDto();
		flowStepDto.setName(flowStep.getName());
		flowStepDto.setCode(flowStep.getCode());
		return flowStepDto;
}

}

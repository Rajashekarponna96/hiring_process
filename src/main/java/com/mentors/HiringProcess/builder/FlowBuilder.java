package com.mentors.HiringProcess.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.FlowDto;
import com.mentors.HiringProcess.dto.FlowStepDto;
import com.mentors.HiringProcess.model.Flow;
import com.mentors.HiringProcess.model.FlowStep;

@Component
public class FlowBuilder {
   
	public Flow toModel(FlowDto flowDto) {

		Flow flow = new Flow();
		flow.setId(flowDto.getId());
		flow.setName(flowDto.getName());
			
		return flow;
	}

	
	public FlowDto toDto(Flow flow) {
		FlowDto flowdto = new FlowDto();
		flowdto.setName(flow.getName());
		
		List<FlowStepDto> flowStepDtos = new ArrayList<>();
	    for (FlowStep flowStep : flow.getSteps()) {
	    	FlowStepDto flowStepDto = new FlowStepDto();
	    	flowStepDto.setId(flowStep.getId());
	    	flowStepDtos.add(flowStepDto);
	    }
	    flowdto.setSteps(flowStepDtos);
		return flowdto;
}
}

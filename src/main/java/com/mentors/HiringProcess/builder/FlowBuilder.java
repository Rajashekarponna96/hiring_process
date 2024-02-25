package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.FlowDto;
import com.mentors.HiringProcess.model.Flow;

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
		
		return flowdto;
}
}

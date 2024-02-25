package com.mentors.HiringProcess.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.HiringFlowDto;
import com.mentors.HiringProcess.model.HiringFlow;
@Component
public class HiringFlowBuilder {
	
	@Autowired
	private FlowBuilder flowBuilder;

   
	
	public HiringFlow toModel(HiringFlowDto hiringFlowDto) {

		HiringFlow hiringflow = new HiringFlow();
		hiringflow.setId(hiringFlowDto.getId());
		hiringflow.setType(hiringFlowDto.getType());;
		hiringflow.setDescription(hiringFlowDto.getDescription());
		hiringflow.setSource(flowBuilder.toModel(hiringFlowDto.getSource()));
		
		return hiringflow;
	}

	
	public HiringFlowDto toDto(HiringFlow hiringflow) {
		HiringFlowDto hiringflowdto = new HiringFlowDto();
		hiringflowdto.setType(hiringflow.getType());
		hiringflowdto.setDescription(hiringflow.getDescription());
		hiringflowdto.setSource(flowBuilder.toDto(hiringflow.getSource()));
		return hiringflowdto;
}

}

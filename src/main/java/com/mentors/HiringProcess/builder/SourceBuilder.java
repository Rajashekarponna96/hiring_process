package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.SourceDto;
import com.mentors.HiringProcess.model.Source;

@Component
public class SourceBuilder {
	
	public Source toModel(SourceDto sourceDto) {

		Source source = new Source();
		source.setId(sourceDto.getId());
		source.setName(sourceDto.getName());
		source.setDescription(sourceDto.getDescription());
		
		return source;
	}

	
	public SourceDto toDto(Source source) {
		SourceDto sourcedto = new SourceDto();
		sourcedto.setName(source.getName());
		sourcedto.setDescription(source.getDescription());
		return sourcedto;
}
}

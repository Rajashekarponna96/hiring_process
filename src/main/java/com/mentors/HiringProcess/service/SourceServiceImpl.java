package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mentors.HiringProcess.builder.SourceBuilder;
import com.mentors.HiringProcess.dto.SourceDto;
import com.mentors.HiringProcess.model.Source;
import com.mentors.HiringProcess.repository.SourceRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SourceServiceImpl  implements SourceService{
	@Autowired
	private SourceRepository  sourceRepository;
	
	@Autowired
	private SourceBuilder sourceBuilder;

	@Override
	public List<SourceDto> getAll() {
		List<SourceDto> sourceDto = new ArrayList<>();
		 List<Source> sourceList = sourceRepository.findAll();
		 if(sourceList!=null) {
			 sourceList.forEach(source-> {
				 sourceDto.add(sourceBuilder.toDto(source));
			 });
		 }
		 
		
		return sourceDto;
	}

}

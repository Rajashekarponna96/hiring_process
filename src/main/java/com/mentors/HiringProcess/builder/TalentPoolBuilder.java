package com.mentors.HiringProcess.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.TalentPoolDto;
import com.mentors.HiringProcess.model.TalentPool;

@Component
public class TalentPoolBuilder {
	public TalentPool toModel(TalentPoolDto talentPoolDto) {
		
		if(talentPoolDto ==null) {
			return null;
		}

		TalentPool talentPool = new TalentPool();
		if(talentPoolDto!=null) {
			
				talentPool.setId(talentPoolDto.getId());
						
		}
		talentPool.setName(talentPoolDto.getName());
		talentPool.setDescription(talentPoolDto.getDescription());
		talentPool.setCreatedTimestamp(talentPoolDto.getCreatedTimestamp());
		talentPool.setModifiedTimestamp(talentPoolDto.getModifiedTimestamp());

		return talentPool;
	}

	public TalentPoolDto toDto(TalentPool talentPool) {
		TalentPoolDto talentPoolDto= null;
		if(talentPool!=null) {
			 talentPoolDto = new TalentPoolDto();
			 
				talentPoolDto.setId(talentPool.getId());
				talentPoolDto.setName(talentPool.getName());
				talentPoolDto.setDescription(talentPool.getDescription());
				talentPoolDto.setCreatedTimestamp(talentPool.getCreatedTimestamp());
				talentPoolDto.setModifiedTimestamp(talentPool.getModifiedTimestamp());
		}
	    
		return talentPoolDto;
	}

	public List<TalentPoolDto> toDtoList(List<TalentPool> list) {

		List<TalentPoolDto> dtos = new ArrayList<>();
		for (TalentPool model : list) {
			dtos.add(toDto(model));
		}
		return dtos;

	}
}

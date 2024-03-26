package com.mentors.HiringProcess.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.PocDto;
import com.mentors.HiringProcess.model.Poc;

@Component
public class PocBuilder {
	
	public Poc toModel(PocDto pocDto) {

		Poc poc = new Poc();
		poc.setId(pocDto.getId());
		poc.setName(pocDto.getName());
		poc.setMobile(pocDto.getMobile());	
		poc.setEmail(pocDto.getEmail());
		return poc;
	}

	
	public PocDto toDto(Poc poc) {
		
		PocDto pocDto= new PocDto();
		pocDto.setId(poc.getId());
		pocDto.setName(poc.getName());
		pocDto.setMobile(poc.getMobile());
		pocDto.setEmail(poc.getEmail());
		return pocDto;
}
	
	public List<PocDto> toDtoList(List<Poc> list){
		List<PocDto> dtos = new ArrayList<>();
	    for (Poc poc : list) {
	    	dtos.add(toDto(poc));
	    }
	    return dtos;
	}
	
	
	public List<Poc> toModelList(List<PocDto> dtos){
		 List<Poc> models = new ArrayList<>();
		 if(dtos!=null) {
		    for (PocDto dto : dtos) {
		    models.add(toModel(dto));
		    }
		 }
		    
		 return models;
		    		
	}

}

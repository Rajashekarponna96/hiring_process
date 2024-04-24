package com.mentors.HiringProcess.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mentors.HiringProcess.dto.JobDto;
import com.mentors.HiringProcess.dto.TalentPoolDto;

public interface TalentPoolServiceI {

	void add(TalentPoolDto talentPoolDto);

	List<TalentPoolDto> findAll();

	void update(TalentPoolDto talentPoolDto,Long id);
	
	 Page<TalentPoolDto> getAllTalentPool(Pageable pageable, String code);

}

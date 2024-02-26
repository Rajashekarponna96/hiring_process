package com.mentors.HiringProcess.service;

import java.util.List;

import com.mentors.HiringProcess.dto.TalentPoolDto;

public interface TalentPoolServiceI {

	void add(TalentPoolDto talentPoolDto);

	List<TalentPoolDto> findAll();

	void update(TalentPoolDto talentPoolDto);

}

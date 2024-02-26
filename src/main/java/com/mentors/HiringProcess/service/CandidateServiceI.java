package com.mentors.HiringProcess.service;

import java.util.List;

import com.mentors.HiringProcess.dto.CandidateDto;

public interface CandidateServiceI {

	void add(CandidateDto candidateDto);

	void update(Long id, CandidateDto candidateDto);

	List<CandidateDto> getAll();

	void delete(Long id);

	CandidateDto findOne(Long id);

}

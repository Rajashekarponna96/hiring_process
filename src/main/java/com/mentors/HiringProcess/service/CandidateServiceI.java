package com.mentors.HiringProcess.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.RecruiterDto;

public interface CandidateServiceI {

	void add(CandidateDto candidateDto);

	void update(Long id, CandidateDto candidateDto);

	List<CandidateDto> getAll();

	void delete(Long id);

	CandidateDto findOne(Long id);
	
	 List<CandidateDto> getCandidatesByCriteria(String firstName, String lastName, String email);
	 
	 Page<CandidateDto> getAllCandidates(Pageable pageable, String code);

}

package com.mentors.HiringProcess.service;

import java.util.List;

import com.mentors.HiringProcess.dto.CandidateEmailDto;

public interface CandidateEmailServiceI {

	void addCandidateEmail(CandidateEmailDto candidateEmailDto);

	List<CandidateEmailDto> findAll();

	void update(Long id, CandidateEmailDto candidateEmailDto);

	void delete(Long id);

}

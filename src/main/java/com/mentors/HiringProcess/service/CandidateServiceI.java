package com.mentors.HiringProcess.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.RecruiterDto;
import com.mentors.HiringProcess.dto.VendorDto;
import com.mentors.HiringProcess.model.HiringFlowType;

public interface CandidateServiceI {

	void add(CandidateDto candidateDto);

	void update(Long id, CandidateDto candidateDto);

	List<CandidateDto> getAll();

	void delete(Long id);

	CandidateDto findOne(Long id);
	
	 List<CandidateDto> getCandidatesByCriteria(String firstName, String lastName, String email);
	 
	 Page<CandidateDto> getAllCandidates(Pageable pageable, String code);
	 
	 Page<CandidateDto> getAllCandidatesWithPagination(Pageable pageable);
	 
	 Page<CandidateDto> getAllInCandidatesWithPagination(Pageable pageable);
	 
	 List<CandidateDto> getCandidatesByVendorId(Long vendorId);
	 
	 CandidateDto getCandidateDetailsByUserId(Long userId);
	  
	List<CandidateDto> getCandidatesDettailsByStage(HiringFlowType stage);
	
	Page<CandidateDto> getCandidatesDettailsByStagewithPagination(HiringFlowType stage,Pageable pageable);
	 


}

package com.mentors.HiringProcess.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.RecruiterDto;
import com.mentors.HiringProcess.dto.VendorDto;

public interface CandidateServiceI {

	void add(CandidateDto candidateDto);

	void update(Long id, CandidateDto candidateDto);

	List<CandidateDto> getAll();

	void delete(Long id);

	CandidateDto findOne(Long id);
	
	 List<CandidateDto> getCandidatesByCriteria(String firstName, String lastName, String email);
	 
	 Page<CandidateDto> getAllCandidates(Pageable pageable, String code);
	 
//	 List<CandidateDto> getCandidatesByVendor(VendorDto vendorDto);
	  List<CandidateDto> getCandidatesByVendorId(Long vendorId);
}

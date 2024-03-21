package com.mentors.HiringProcess.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mentors.HiringProcess.dto.RecruiterDto;
import com.mentors.HiringProcess.model.Recruiter;

public interface RecruiterServiceI {

	void add(RecruiterDto recruiterDto);

	List<RecruiterDto> findAll();

	void update(Long id, RecruiterDto recruiterDto);

	void delete(Long id);

	Page<Recruiter> getUsersByCode(String code, Pageable pageable);
	
	Page<RecruiterDto> getAllRecruiters(Pageable pageable, String firstName);


}

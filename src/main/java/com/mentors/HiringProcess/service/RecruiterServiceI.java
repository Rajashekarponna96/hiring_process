package com.mentors.HiringProcess.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mentors.HiringProcess.dto.RecruiterDto;


public interface RecruiterServiceI {

	void add(RecruiterDto recruiterDto);

	List<RecruiterDto> findAll();

	void update(Long id, RecruiterDto recruiterDto);

	void delete(Long id);
	
	Page<RecruiterDto> getAllRecruiters(Pageable pageable, String code);
	
	Page<RecruiterDto> getAllRecruitersWithPagination(Pageable pageable);


}

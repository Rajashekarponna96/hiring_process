package com.mentors.HiringProcess.service;

import java.util.List;

import com.mentors.HiringProcess.dto.RecruiterDto;

public interface RecruiterServiceI {

	void add(RecruiterDto recruiterDto);

	List<RecruiterDto> findAll();

	void update(Long id, RecruiterDto recruiterDto);

	void delete(Long id);

}

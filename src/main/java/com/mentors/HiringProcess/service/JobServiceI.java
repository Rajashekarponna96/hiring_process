package com.mentors.HiringProcess.service;

import java.util.List;

import com.mentors.HiringProcess.dto.JobDto;

public interface JobServiceI {

	void addJob(JobDto jobDto);

	List<JobDto> allJobs();

	void updateJob(Long id, JobDto jobDto);

	void deleteJob(Long id);

}

package com.mentors.HiringProcess.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mentors.HiringProcess.dto.AssignJobsToVendorsDto;
import com.mentors.HiringProcess.dto.JobDto;
import com.mentors.HiringProcess.dto.JobSummaryDto;
import com.mentors.HiringProcess.model.Job;
import com.mentors.HiringProcess.model.Recruiter;
import com.mentors.HiringProcess.model.Vendor;

public interface JobServiceI {

	void addJob(JobDto jobDto);

	List<JobDto> allJobs();

	void updateJob(Long id, JobDto jobDto);

	void deleteJob(Long id);

	List<JobSummaryDto> getAllJobSummaries();

	List<JobDto> allJobsWithClients();

	Page<JobDto> getAllJobs(Pageable pageable, String code);

	Page<JobDto> getAllJobsWithPagination(Pageable pageable);

	//
	List<Job> getAllJobs();

	List<Vendor> getAllVendors();

	void assignVendorToJob(Long jobId, Long vendorId);

	List<Recruiter> getAllRecruiters();

	

	void assignJobsToVendors(AssignJobsToVendorsDto dto);

}

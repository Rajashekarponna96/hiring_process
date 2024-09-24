package com.mentors.HiringProcess.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.AssignJobsToRecruitersDto;
import com.mentors.HiringProcess.dto.AssignJobsToVendorsDto;
import com.mentors.HiringProcess.dto.JobDto;
import com.mentors.HiringProcess.dto.JobSummaryDto;
import com.mentors.HiringProcess.model.Job;
import com.mentors.HiringProcess.model.Recruiter;
import com.mentors.HiringProcess.model.Vendor;
import com.mentors.HiringProcess.service.JobServiceI;

@RestController
@RequestMapping(value = "/job")
@CrossOrigin
public class JobController {

	@Autowired
	private JobServiceI jobServiceI;

	@PostMapping("/")
	public void addJob(@RequestBody JobDto jobDto) {
		jobDto.validateRequiredAttibutes(jobDto);
		jobServiceI.addJob(jobDto);
	}

	@GetMapping("/all")
	public List<JobDto> allJobs() {
		return jobServiceI.allJobs();
	}

	@PutMapping("/{id}")
	public void updateJob(@PathVariable Long id, @RequestBody JobDto jobDto) {
		jobServiceI.updateJob(id, jobDto);
	}

	@DeleteMapping("/{id}")
	public void deleteJob(@PathVariable Long id) {
		jobServiceI.deleteJob(id);
	}

	@GetMapping("/summaries")
	public List<JobSummaryDto> getAllJobSummaries() {
		return jobServiceI.getAllJobSummaries();
	}

	@GetMapping("/with-clients")
	public List<JobDto> getAllJobsWithClients() {
		return jobServiceI.allJobsWithClients();
	}

	@GetMapping("/searchpage")
	public Page<JobDto> getAllJobs(@RequestParam int page, @RequestParam int size, @RequestParam String code) {
		//Pageable pageable = PageRequest.of(page, size);
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdTimestamp"));
		return jobServiceI.getAllJobs(pageable, code);
	}

	@GetMapping("/joblistwithpagination")
	public Page<JobDto> getAllJobsWithPagination(@RequestParam int page, @RequestParam int size) {
		//Pageable pageable = PageRequest.of(page, size);
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdTimestamp"));
		return jobServiceI.getAllJobsWithPagination(pageable);
	}

	//
	@GetMapping("/alljobslist")
	public List<Job> getAllJobs() {
		return jobServiceI.getAllJobs();
	}

	@GetMapping("/allvendorslist")
	public List<Vendor> getAllVendors() {
		return jobServiceI.getAllVendors();
	}
	
	@GetMapping("/allrecruiterslist")
	public List<Recruiter> getAllRecruiters() {
		return jobServiceI.getAllRecruiters();
	}
 
	@PostMapping("/{jobId}/vendors")
	public ResponseEntity<Void> assignVendorToJob(@PathVariable Long jobId,
			@RequestBody Map<String, Long> requestBody) {
		Long vendorId = requestBody.get("vendorId");
		jobServiceI.assignVendorToJob(jobId, vendorId);
		return ResponseEntity.noContent().build();
	}
	
	 @PostMapping("/assign-jobs-to-vendors")
	    public ResponseEntity<Void> assignJobsToVendors(@RequestBody AssignJobsToVendorsDto dto) {
		 jobServiceI.assignJobsToVendors(dto);
	        return ResponseEntity.ok().build();
	    }

}
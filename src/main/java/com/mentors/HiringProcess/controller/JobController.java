package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.mentors.HiringProcess.dto.ClientDto;
import com.mentors.HiringProcess.dto.JobDto;
import com.mentors.HiringProcess.dto.JobSummaryDto;
import com.mentors.HiringProcess.service.JobServiceI;



@RestController
@RequestMapping(value = "/job")
@CrossOrigin
public class JobController {

	@Autowired
	private JobServiceI jobServiceI;
	
	@PostMapping("/")
	public void addJob(@RequestBody JobDto  jobDto) {
		jobDto.validateRequiredAttibutes(jobDto);
		jobServiceI.addJob(jobDto);
	}
	
	@GetMapping("/all")
	public List<JobDto> allJobs() {
		return jobServiceI.allJobs();
	}
	
	
	@PutMapping("/{id}")
	public void updateJob(@PathVariable Long id,  @RequestBody JobDto  jobDto) {
		jobServiceI.updateJob(id,jobDto);
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
     public Page<JobDto> getAllJobs(@RequestParam int page, @RequestParam int size,
		        @RequestParam String code) {
		    Pageable pageable = PageRequest.of(page, size);
		    return jobServiceI.getAllJobs(pageable,code);
		}
	 
	 
	 @GetMapping("/joblistwithpagination")
     public Page<JobDto> getAllJobsWithPagination(@RequestParam int page, @RequestParam int size) {
		    Pageable pageable = PageRequest.of(page, size);
		    return jobServiceI.getAllJobsWithPagination(pageable);
		}
	 
	 
}
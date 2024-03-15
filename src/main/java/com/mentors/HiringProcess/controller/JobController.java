package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.JobDto;
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
}

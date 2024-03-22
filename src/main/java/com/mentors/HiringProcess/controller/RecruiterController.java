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

import com.mentors.HiringProcess.dto.RecruiterDto;
import com.mentors.HiringProcess.service.RecruiterServiceI;

@RestController
@RequestMapping(value = "/recruiter")
@CrossOrigin
public class RecruiterController {

	@Autowired
	private RecruiterServiceI recruiterServiceI;

	@PostMapping(value = "/")
	public void add(@RequestBody RecruiterDto recruiterDto) {
		recruiterDto.validateRequiredAttibutes(recruiterDto);
		recruiterServiceI.add(recruiterDto);
	}

	@GetMapping(value = "/all")
	public List<RecruiterDto> findAll() {
		return recruiterServiceI.findAll();
	}

	@PutMapping(value = "/{id}")
	public void update(@PathVariable Long id, @RequestBody RecruiterDto recruiterDto) {
		recruiterServiceI.update(id, recruiterDto);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		recruiterServiceI.delete(id);
	}

	
	@GetMapping("/searchpage")
	public Page<RecruiterDto> getAllRecruiters(@RequestParam int page, @RequestParam int size,
	        @RequestParam String code) {
	    Pageable pageable = PageRequest.of(page, size);
	    return recruiterServiceI.getAllRecruiters(pageable,code);
	}

}

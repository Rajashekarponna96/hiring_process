package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.service.CandidateServiceI;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/candidate")
@CrossOrigin
public class CandidateController {
	
	@Autowired
	private CandidateServiceI candidateServiceI;
	
	@PostMapping(value = "/")
	public void add(@RequestBody CandidateDto candidateDto) {
		candidateServiceI.add(candidateDto);
	}
	
	
	@PutMapping(value = "/{id}")
	public void update(@PathVariable Long id,@RequestBody CandidateDto candidateDto) {
		candidateServiceI.update(id,candidateDto);
	}
	
	@GetMapping(value = "/all")
	public List<CandidateDto> getAll() {
		return candidateServiceI.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public CandidateDto findOne(@PathVariable Long id) {
		return candidateServiceI.findOne(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		candidateServiceI.delete(id);
	}

}

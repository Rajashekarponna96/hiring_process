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

import com.mentors.HiringProcess.dto.CandidateEmailDto;
import com.mentors.HiringProcess.service.CandidateEmailServiceI;

@RestController
@RequestMapping(value = "/email")
@CrossOrigin
public class CandidateEmailController {
	
	
	@Autowired
	private CandidateEmailServiceI candidateEmailServiceI;
	
	@PostMapping("/")
	public void addCandidateEmail(@RequestBody CandidateEmailDto  candidateEmailDto) {
		candidateEmailDto.validateRequiredAttibutes(candidateEmailDto);
		candidateEmailServiceI.addCandidateEmail(candidateEmailDto);
	}
	
	@GetMapping(value = "/all")
	public List<CandidateEmailDto> findAll() {
		return candidateEmailServiceI.findAll();
	}

	@PutMapping(value = "/{id}")
	public void update(@PathVariable Long id, @RequestBody CandidateEmailDto candidateEmailDto) {
		candidateEmailServiceI.update(id, candidateEmailDto);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		candidateEmailServiceI.delete(id);
	}
	
	

}

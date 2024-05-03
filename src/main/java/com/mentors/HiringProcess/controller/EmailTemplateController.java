package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mentors.HiringProcess.dto.EmailTemplateDto;
import com.mentors.HiringProcess.service.EmailTemplateServiceI;

@RestController
@RequestMapping(value = "/email")
@CrossOrigin
public class EmailTemplateController {
	
	
	@Autowired
	private EmailTemplateServiceI candidateEmailServiceI;
	
	@PostMapping("/")
	public void addCandidateEmail(@RequestBody EmailTemplateDto  candidateEmailDto) {
		candidateEmailDto.validateRequiredAttibutes(candidateEmailDto);
		candidateEmailServiceI.addCandidateEmail(candidateEmailDto);
	}
	
	@GetMapping(value = "/all")
	public List<EmailTemplateDto> findAll() {
		return candidateEmailServiceI.findAll();
	}

	@PutMapping(value = "/{id}")
	public void update(@PathVariable Long id, @RequestBody EmailTemplateDto candidateEmailDto) {
		candidateEmailServiceI.update(id, candidateEmailDto);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		candidateEmailServiceI.delete(id);
	}
	
	@GetMapping("/byTitle")
    public ResponseEntity<EmailTemplateDto> getSubjectAndBodyByTitle(
            @RequestParam String title) {
		EmailTemplateDto emailDTO = candidateEmailServiceI.getSubjectAndBodyByTitle(title);
        if (emailDTO != null) {
            return ResponseEntity.ok(emailDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	

}
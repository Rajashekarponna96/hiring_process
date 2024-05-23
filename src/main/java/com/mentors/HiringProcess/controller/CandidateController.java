package com.mentors.HiringProcess.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
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

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.RecruiterDto;
import com.mentors.HiringProcess.dto.VendorDto;
import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.EmailTemplate;
import com.mentors.HiringProcess.repository.CandidateRepository;
import com.mentors.HiringProcess.repository.EmailTemplateRepository;
import com.mentors.HiringProcess.service.CandidateServiceI;
import com.mentors.HiringProcess.service.EmailService;



@RestController
@RequestMapping(value = "/candidate")
@CrossOrigin
public class CandidateController {
	
	@Autowired
	private CandidateServiceI candidateServiceI;
	
	
	@Autowired
	public CandidateRepository candidateRepository;
	
	@Autowired
	public EmailTemplateRepository emailTemplateRepository;
	
	@Autowired
	public EmailService emailService;
	
	@PostMapping(value = "/")
	public void add(@RequestBody CandidateDto candidateDto) {
		candidateDto.validateREquiredAttibutes(candidateDto);
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
	
	//Filter Api For  candidate
	@GetMapping("/candidates")
    public List<CandidateDto> getCandidatesByCriteria(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email
//            @RequestParam(required = false) String mobile,
//            @RequestParam(required = false) String alterMobile,
//            @RequestParam(required = false) String source,
//            @RequestParam(required = false) String stage,
//            @RequestParam(required = false) String current
            )
	{
        return candidateServiceI.getCandidatesByCriteria(firstName, lastName, email);
    }
	
	//Globel Search
	@GetMapping("/searchpage")
	public Page<CandidateDto> getAllRecruiters(@RequestParam int page, @RequestParam int size,
	        @RequestParam String code) {
	    Pageable pageable = PageRequest.of(page, size);
	    return candidateServiceI.getAllCandidates(pageable,code);
	}
	
	
	   //candidate list with pagination
		@GetMapping("/candidatelistwithpagination")
		public Page<CandidateDto> getAllCandidatesWithPagination(@RequestParam int page, @RequestParam int size) {
		    Pageable pageable = PageRequest.of(page, size);
		    return candidateServiceI.getAllCandidatesWithPagination(pageable);
		}
		
		@GetMapping("/inactivecandidatelistwithpagination")
		public Page<CandidateDto> getAllInCandidatesWithPagination(@RequestParam int page, @RequestParam int size) {
		    Pageable pageable = PageRequest.of(page, size);
		    return candidateServiceI.getAllInCandidatesWithPagination(pageable);
		}
		
		//@Scheduled emails
		@GetMapping("/mail")
		public void mail() {
			List<Candidate> candidateList = candidateRepository.findByStage();
			System.out.println("we are in sourced delay time ----------------------");
			LocalDateTime   presentTime = LocalDateTime.now();
			for (Candidate candidate : candidateList) {
				LocalDateTime	createdTime =candidate.getCreatedTimestamp();
				Duration duration = Duration.between(createdTime, presentTime);
		        long timedifference = duration.toMinutes(); // You can change toSeconds(), toHours(), etc. based on your need
		        System.out.println("Time difference in minutes: " + timedifference);
		        long fixedTime = 2880;
		        if(timedifference > 2880) {
		        	String candidateName = candidate.getFirstName();
		        	String uploadDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		        	EmailTemplate emailTemplate  = emailTemplateRepository.findByTitle(candidate.getStage().toString());
		    		String body=emailTemplate.getBody();
		    		String updatedBody = body.replace("[CandidateName]", candidateName)
		                     .replace("[UploadDate]", uploadDate);
		    		emailService.sendSimpleMessage(candidate.getEmail(), emailTemplate.getSubject(),updatedBody,null, null, null);

		        }
				
				
			}
				
		}




}

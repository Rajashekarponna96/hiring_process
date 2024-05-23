package com.mentors.HiringProcess.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.EmailTemplate;
import com.mentors.HiringProcess.repository.CandidateRepository;
import com.mentors.HiringProcess.repository.EmailTemplateRepository;

@Component
public class MailServiceImpl {
	@Autowired
	public CandidateRepository candidateRepository;
	
	@Autowired
	public EmailTemplateRepository emailTemplateRepository;
	
	@Autowired
	public EmailService emailService;
	
	@Scheduled(fixedRate=60)
	public void mailSend() {
		
		sourcedDelayTime();
		
	}
		
		public void sourcedDelayTime(){
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

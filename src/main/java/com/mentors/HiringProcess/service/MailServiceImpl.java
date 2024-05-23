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
import com.mentors.HiringProcess.model.HiringFlowActivity;
import com.mentors.HiringProcess.model.Job;
import com.mentors.HiringProcess.model.Recruiter;
import com.mentors.HiringProcess.repository.CandidateRepository;
import com.mentors.HiringProcess.repository.EmailTemplateRepository;
import com.mentors.HiringProcess.repository.HiringFlowActivityRepository;
import com.mentors.HiringProcess.repository.JobRepository;

@Component
public class MailServiceImpl {
	@Autowired
	public CandidateRepository candidateRepository;
	
	@Autowired
	public EmailTemplateRepository emailTemplateRepository;
	
	@Autowired
	public EmailService emailService;
	
	@Autowired 
	public JobRepository jobRepository;
	
	@Autowired
	public HiringFlowActivityRepository hiringFlowActivityRepository;
	
	@Scheduled(fixedRate=6000)
	public void mailSend() {
		
		//sourcedDelayTime();
		screenincreeningDEelayTime();
		
	}
		
		public void sourcedDelayTime(){
			List<Candidate> candidateList = candidateRepository.findByStage();
		System.out.println("we are in sourced delay time ----------------------");
		LocalDateTime   presentTime = LocalDateTime.now();
		for (Candidate candidate : candidateList) {
			if(candidate!=null) {
			Long candidateId = candidate.getId();
			 Job jobDetails = candidate.getJob();
			 if(jobDetails!=null) {
				 Recruiter recruiterDetails =jobDetails.getRecruiters();
				 
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
	    		
	    		String recruiterName = recruiterDetails.getFirstName();
	    		String updatedBodyForRecruiter = body.replace("[CandidateName]", recruiterName)
	                     .replace("[UploadDate]", uploadDate);
	    		emailService.sendSimpleMessage(recruiterDetails.getEmail(), emailTemplate.getSubject(),updatedBodyForRecruiter,null, null, null);


	        }
			
			 }
			
		}
		}
			
		}
		
	public void screenincreeningDEelayTime(){
			
		List<HiringFlowActivity> hiringFlowActivityList = hiringFlowActivityRepository.findByHiringFlowType();
		System.out.println("we are in screening delay time ----------------------");
		LocalDateTime   presentTime = LocalDateTime.now();
		for (HiringFlowActivity hiringFlowActivity : hiringFlowActivityList) {
			LocalDateTime dbTime = hiringFlowActivity.getCreatedDate();
			Duration duration = Duration.between(dbTime, presentTime);
	        long timedifference = duration.toMinutes(); // You can change toSeconds(), toHours(), etc. based on your need
	        System.out.println("Time difference in minutes: " + timedifference);
	        long fixedTime = 2880;
	        if(timedifference > 2880) {
	        	Recruiter recruiter = hiringFlowActivity.getCandidate().getJob().getRecruiters();
	        	System.out.println("recruter details are------"+recruiter.getEmail());
	        	String recruiterName = recruiter.getFirstName();
	        	String stage = hiringFlowActivity.getCandidate().getStage().toString();
	        	EmailTemplate emailTemplate  = emailTemplateRepository.findByTitle("Screening");
	        	if(emailTemplate != null) {
	    		String body=emailTemplate.getBody();
	    		String uploadDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	    		String updatedBodyForRecruiter = body.replace("[CandidateName]", recruiterName)
	                     .replace("[UploadDate]", uploadDate);
	    		emailService.sendSimpleMessage(recruiter.getEmail(), emailTemplate.getSubject(),updatedBodyForRecruiter,null, null, null);
	        	}

	        	
	        }
			
		}
		
			
		}
		
		
	

}

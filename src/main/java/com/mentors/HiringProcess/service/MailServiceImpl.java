package com.mentors.HiringProcess.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.EmailTemplate;
import com.mentors.HiringProcess.model.HiringFlowActivity;
import com.mentors.HiringProcess.model.HiringFlowType;
import com.mentors.HiringProcess.model.Job;
import com.mentors.HiringProcess.model.Recruiter;
import com.mentors.HiringProcess.repository.CandidateRepository;
import com.mentors.HiringProcess.repository.EmailTemplateRepository;
import com.mentors.HiringProcess.repository.HiringFlowActivityRepository;
import com.mentors.HiringProcess.repository.JobRepository;

@Component
public class MailServiceImpl {
	
	private static Logger log = Logger.getAnonymousLogger();
	
	//private static Logger logger = Logger.getLogger('hello', MailServiceImpl.class)
	
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
		
		sourcedDelayTime();
		screenincreeningDelayTime();
		InterviewDelayTime();
		PreboardingDelayTime();
		HiredDelayTime();
		ArchivedDelayTime();
		HoldDelayTime();
		
		
	}
		
		public void sourcedDelayTime(){
			HiringFlowType  hiringFlowType=  HiringFlowType.Sourced;
//	        List<HiringFlowActivity> hiringFlowActivityList = hiringFlowActivityRepository.findByHiringFlowType(hiringFlowType);
//	        sendMailsForDelayProcess(hiringFlowActivityList,hiringFlowType);
//			
			List<Candidate> candidateList = candidateRepository.findByStage(hiringFlowType);
		
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
		
	public void screenincreeningDelayTime(){
		HiringFlowType  hiringFlowType=  HiringFlowType.Screening;
//        List<HiringFlowActivity> hiringFlowActivityList = hiringFlowActivityRepository.findByHiringFlowType(hiringFlowType);
//        sendMailsForDelayProcess(hiringFlowActivityList,hiringFlowType);
		
		List<Candidate> candidateList = candidateRepository.findByStage(hiringFlowType);
		sendMailsToRecrutiterForDelayProcess(candidateList);
		
		}
	
	public void InterviewDelayTime() {
		HiringFlowType  hiringFlowType=  HiringFlowType.Interview;
//        List<HiringFlowActivity> hiringFlowActivityList = hiringFlowActivityRepository.findByHiringFlowType(hiringFlowType);
//        sendMailsForDelayProcess(hiringFlowActivityList,hiringFlowType);
        
        
        List<Candidate> candidateList = candidateRepository.findByStage(hiringFlowType);
		sendMailsToRecrutiterForDelayProcess(candidateList);
	}
	
	public void PreboardingDelayTime(){
		HiringFlowType  hiringFlowType=  HiringFlowType.Preboarding;
//        List<HiringFlowActivity> hiringFlowActivityList = hiringFlowActivityRepository.findByHiringFlowType(hiringFlowType);
//        sendMailsForDelayProcess(hiringFlowActivityList,hiringFlowType);
		
		List<Candidate> candidateList = candidateRepository.findByStage(hiringFlowType);
		sendMailsToRecrutiterForDelayProcess(candidateList);
		
	}
	
	public void HiredDelayTime() {
		HiringFlowType  hiringFlowType=  HiringFlowType.Screening;
//        List<HiringFlowActivity> hiringFlowActivityList = hiringFlowActivityRepository.findByHiringFlowType(hiringFlowType);
//        sendMailsForDelayProcess(hiringFlowActivityList,hiringFlowType);
		
		List<Candidate> candidateList = candidateRepository.findByStage(hiringFlowType);
		sendMailsToRecrutiterForDelayProcess(candidateList);
		
	}
	
	public void  ArchivedDelayTime() {
		HiringFlowType  hiringFlowType=  HiringFlowType.Archived;
//        List<HiringFlowActivity> hiringFlowActivityList = hiringFlowActivityRepository.findByHiringFlowType(hiringFlowType);
//        sendMailsForDelayProcess(hiringFlowActivityList,hiringFlowType);
//		
		List<Candidate> candidateList = candidateRepository.findByStage(hiringFlowType);
		sendMailsToRecrutiterForDelayProcess(candidateList);
	}
	
	
	
	public void HoldDelayTime() {
		HiringFlowType  hiringFlowType=  HiringFlowType.Hold;
//        List<HiringFlowActivity> hiringFlowActivityList = hiringFlowActivityRepository.findByHiringFlowType(hiringFlowType);
//        sendMailsForDelayProcess(hiringFlowActivityList,hiringFlowType);
		
		List<Candidate> candidateList = candidateRepository.findByStage(hiringFlowType);
		sendMailsToRecrutiterForDelayProcess(candidateList);
		
	}
	
	//send mails based on hiring filow actitity table
	public void  sendMailsForDelayProcess(List<HiringFlowActivity> hiringFlowActivityList,HiringFlowType  hiringFlowType) {
		LocalDateTime   presentTime = LocalDateTime.now();
		for (HiringFlowActivity hiringFlowActivity : hiringFlowActivityList) {
			LocalDateTime dbTime = hiringFlowActivity.getCreatedDate();
			Duration duration = Duration.between(dbTime, presentTime);
	        long timedifference = duration.toMinutes(); // You can change toSeconds(), toHours(), etc. based on your need
	        //System.out.println("Time difference in minutes: " + timedifference);
	        log.info("Time difference in minutes: " + timedifference);
	        long fixedTime = 2880;
	        if(timedifference > 2880) {
	        	Recruiter recruiter = hiringFlowActivity.getCandidate().getJob().getRecruiters();
	        	System.out.println("recruter details are------"+recruiter.getEmail());
	        	String recruiterName = recruiter.getFirstName();
	        	String stage = hiringFlowActivity.getCandidate().getStage().toString();
	        	EmailTemplate emailTemplate  = emailTemplateRepository.findByTitle(hiringFlowActivity.getHiringFlowType().name());
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
	
	
	//send mails for delay process based on candidate table
	
	public void sendMailsToRecrutiterForDelayProcess(List<Candidate> candidateList) {
		LocalDateTime   presentTime = LocalDateTime.now();
		for (Candidate candidate : candidateList) {
			if(candidate!=null) {
			Long candidateId = candidate.getId();
			 Job jobDetails = candidate.getJob();
			 if(jobDetails!=null) {
				 Recruiter recruiterDetails =jobDetails.getRecruiters();
				 
			LocalDateTime	createdTime =candidate.getModifiedTimestamp();
			Duration duration = Duration.between(createdTime, presentTime);
	        long timedifference = duration.toMinutes(); // You can change toSeconds(), toHours(), etc. based on your need
	        System.out.println("Time difference in minutes: " + timedifference);
	        long fixedTime = 2880;
	        if(timedifference > 2880) {
	        	
	        	String uploadDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	        	EmailTemplate emailTemplate  = emailTemplateRepository.findByTitle(candidate.getStage().toString());
	    		String body=emailTemplate.getBody();
	    		String recruiterName = recruiterDetails.getFirstName();
	    		String updatedBodyForRecruiter = body.replace("[CandidateName]", recruiterName)
	                     .replace("[UploadDate]", uploadDate);
	    		emailService.sendSimpleMessage(recruiterDetails.getEmail(), emailTemplate.getSubject(),updatedBodyForRecruiter,null, null, null);


	        }
			
			 }
			
		}
		}
         
		
	}
	
	
		
		
	

}

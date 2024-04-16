package com.mentors.HiringProcess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.EmailRequest;
import com.mentors.HiringProcess.service.EmailService;

@RestController
public class EmailController {
	
	 @Autowired
	    private EmailService emailService;

	    @PostMapping("/sendEmail")
	    public String sendEmail(@RequestBody EmailRequest emailRequest) {
	        emailService.sendSimpleMessage(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
	        return "Email sent successfully";
	    }

}

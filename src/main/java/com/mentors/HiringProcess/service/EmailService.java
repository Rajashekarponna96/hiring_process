package com.mentors.HiringProcess.service;

import java.io.File;
import java.util.List;
import java.util.Spliterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text,String attachmentPath,String htmlContent,List<String> cc) {
//        MimeMessage message = emailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//        try {
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText(text);
//        } catch (MessagingException e) {
//            e.printStackTrace(); // Handle the exception appropriately
//        }
//        emailSender.send(message);
//    }
    	
    	MimeMessage message = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);

            // Set text content
            helper.setText(text, true); 
            
            //set  html content
            helper.setText(htmlContent, true);// true indicates HTML content
            
            // Add CC recipients
            if (cc != null && !cc.isEmpty()) {
                helper.setCc(cc.toArray(new String[0]));
            }

            // Add attachment
            if (attachmentPath != null) {
                File file = new File(attachmentPath);
                helper.addAttachment(file.getName(), file);
            }

            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

}

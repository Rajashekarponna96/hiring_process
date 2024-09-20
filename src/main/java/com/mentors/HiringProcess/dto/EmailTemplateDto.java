package com.mentors.HiringProcess.dto;

import java.time.LocalDateTime;

public class EmailTemplateDto {
	
	 private Long id;
	 
	 private String subject;
	 
	 private String body;
	 
	 private String title;
	 
	 private LocalDateTime createdTimestamp;
	    
	 private LocalDateTime modifiedTimestamp;

	 
	public Long getId() {
		return id;
	}

	public EmailTemplateDto() {
	super();
	this.id = id;
	this.subject = subject;
	this.body = body;
	this.title = title;
}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public LocalDateTime getModifiedTimestamp() {
		return modifiedTimestamp;
	}

	public void setModifiedTimestamp(LocalDateTime modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}
	 
	
	

	public void validateRequiredAttibutes(EmailTemplateDto candidateEmailDto) {
		if(candidateEmailDto.getSubject()==null) {
			throw new RuntimeException("Subject is Mandatory");
		}
		if(candidateEmailDto.getBody()==null) {
			throw new RuntimeException("Email Body is Mandatory");
		}
		if(candidateEmailDto.getTitle()==null) {
			throw new RuntimeException("Email Body is Mandatory");
		}
		
	}
	 
	 

}

package com.mentors.HiringProcess.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.EmailTemplateBuilder;
import com.mentors.HiringProcess.dto.EmailTemplateDto;
import com.mentors.HiringProcess.dto.LocationDto;
import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.EmailTemplate;
import com.mentors.HiringProcess.model.Location;
import com.mentors.HiringProcess.repository.EmailTemplateRepository;

@Service
@Transactional
public class EmailTemplateServiceImpl implements EmailTemplateServiceI{
	
	@Autowired
	private EmailTemplateRepository candidateEmailRepository;
	
	@Autowired
	private EmailTemplateBuilder candidateEmailBuilder;

	@Override
	public void addCandidateEmail(EmailTemplateDto candidateEmailDto) {
		//CandidateEmail candidateEmail = candidateEmailBuilder.toModel(candidateEmailDto);
		String sanitizedSubject = Jsoup.clean(candidateEmailDto.getBody(), Whitelist.none());
		String sanitizedSubject1 = Jsoup.clean(candidateEmailDto.getTitle(), Whitelist.none());
		String sanitizedSubject2 = Jsoup.clean(candidateEmailDto.getSubject(), Whitelist.none());
		EmailTemplate email=new EmailTemplate();
		email.setBody(sanitizedSubject);
		email.setTitle(sanitizedSubject1);
		email.setSubject(sanitizedSubject2);
		candidateEmailRepository.save(email);	
		
	}

	@Override
	public List<EmailTemplateDto> findAll() {
		List<EmailTemplateDto> candidateEmailDtos = new ArrayList<>();
		List<EmailTemplate> candidateEmails = candidateEmailRepository.findAll();
		if (candidateEmails != null) {
			candidateEmails.forEach(candidateEmail -> {
				candidateEmailDtos.add(candidateEmailBuilder.toDto(candidateEmail));
			});
		}
		return candidateEmailDtos;
	}

	@Override
	public void update(Long id, EmailTemplateDto candidateEmailDto) {
		Optional<EmailTemplate> dbCandidateEmailOptional = candidateEmailRepository.findById(id);
		if (dbCandidateEmailOptional.isPresent()) {
            EmailTemplate dbCandidateEmail = dbCandidateEmailOptional.get();
            
            // Update fields with the new values
            String sanitizedBody = Jsoup.clean(candidateEmailDto.getBody(), Whitelist.none());
            dbCandidateEmail.setBody(sanitizedBody);

            String sanitizedTitle = Jsoup.clean(candidateEmailDto.getTitle(), Whitelist.none());
            dbCandidateEmail.setTitle(sanitizedTitle);

            String sanitizedSubject = Jsoup.clean(candidateEmailDto.getSubject(), Whitelist.none());
            dbCandidateEmail.setSubject(sanitizedSubject);

            // Save the updated entity
            candidateEmailRepository.save(dbCandidateEmail);
		}
	}

	@Override
	public void delete(Long id) {
		
		candidateEmailRepository.deleteById(id);
		
	}

	@Override
	public EmailTemplateDto getSubjectAndBodyByTitle(String title) {
		EmailTemplate email = candidateEmailRepository.findByTitle(title);
        if (email != null) {
            return new EmailTemplateBuilder().toDto(email);
        } else {
            return null;
        }
	}

	@Override
	public Page<EmailTemplateDto> getAllEmailsWithPagination(Pageable pageable) {
		Page<EmailTemplate> emailPage = candidateEmailRepository.findAll(pageable);
        return emailPage.map(candidateEmailBuilder::toDto);
	}

	

}

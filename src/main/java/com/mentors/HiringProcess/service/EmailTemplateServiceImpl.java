package com.mentors.HiringProcess.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.EmailTemplateBuilder;
import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.EmailTemplateDto;
import com.mentors.HiringProcess.dto.LocationDto;
import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.EmailTemplate;
import com.mentors.HiringProcess.model.Location;
import com.mentors.HiringProcess.model.Vendor;
import com.mentors.HiringProcess.repository.CandidateRepository;
import com.mentors.HiringProcess.repository.EmailTemplateRepository;
import com.mentors.HiringProcess.specification.EmailTemplateSpecifications;
import com.mentors.HiringProcess.specification.VendorSpecifications;

@Service
@Transactional
public class EmailTemplateServiceImpl implements EmailTemplateServiceI{
	
	@Autowired
	private EmailTemplateRepository candidateEmailRepository;
	
	@Autowired
	private EmailTemplateBuilder candidateEmailBuilder;
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Override
	public void addCandidateEmail(EmailTemplateDto candidateEmailDto,Long candidateId) {
		String sanitizedBody = Jsoup.clean(candidateEmailDto.getBody(), Whitelist.none());
        String sanitizedTitle = Jsoup.clean(candidateEmailDto.getTitle(), Whitelist.none());
        String sanitizedSubject = Jsoup.clean(candidateEmailDto.getSubject(), Whitelist.none());

      
        Optional<Candidate> candidateOptional = candidateRepository.findById(candidateId);
        if (candidateOptional.isPresent()) {
            Candidate candidate = candidateOptional.get();
            String candidateName = candidate.getFirstName(); 
            String uploadDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String updatedBody = sanitizedBody.replace("[CandidateName]", candidateName)
                                              .replace("[UploadDate]", uploadDate);
            String updatedTitle = sanitizedTitle.replace("[CandidateName]", candidateName)
                                                .replace("[UploadDate]", uploadDate);
            String updatedSubject = sanitizedSubject.replace("[CandidateName]", candidateName)
                                                    .replace("[UploadDate]", uploadDate);

            EmailTemplate emailTemplate = new EmailTemplate();
            emailTemplate.setBody(updatedBody);
            emailTemplate.setTitle(updatedTitle);
            emailTemplate.setSubject(updatedSubject);
            candidateEmailRepository.save(emailTemplate);
        } else {
            
        }
		
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

	@Override
	public Page<EmailTemplateDto> getAllTemplates(Pageable pageable, String code) {
		Specification<EmailTemplate> spec = Specification.where(null); // Start with an empty specification

        if (code != null && !code.isEmpty()) {
            spec = spec.and(EmailTemplateSpecifications.hasFields(code));
        }

        Page<EmailTemplate> recruiterPage = candidateEmailRepository.findAll(spec, pageable);
        return recruiterPage.map(candidateEmailBuilder::toDto);
	}



	@Override
	public void addCandidateEmails(EmailTemplateDto candidateEmailDto) {
		String sanitizedSubject = Jsoup.clean(candidateEmailDto.getBody(), Whitelist.none());
		String sanitizedSubject1 = Jsoup.clean(candidateEmailDto.getTitle(), Whitelist.none());
		String sanitizedSubject2 = Jsoup.clean(candidateEmailDto.getSubject(), Whitelist.none());
		EmailTemplate email=new EmailTemplate();
		email.setBody(sanitizedSubject);
		email.setTitle(sanitizedSubject1);
		email.setSubject(sanitizedSubject2);
		candidateEmailRepository.save(email);	
		
	}

	

}

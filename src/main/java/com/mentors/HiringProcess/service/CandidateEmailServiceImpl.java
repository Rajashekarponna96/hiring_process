package com.mentors.HiringProcess.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.CandidateEmailBuilder;
import com.mentors.HiringProcess.dto.CandidateEmailDto;
import com.mentors.HiringProcess.dto.LocationDto;
import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.CandidateEmail;
import com.mentors.HiringProcess.model.Location;
import com.mentors.HiringProcess.repository.CandidateEmailRepository;

@Service
@Transactional
public class CandidateEmailServiceImpl implements CandidateEmailServiceI{
	
	@Autowired
	private CandidateEmailRepository candidateEmailRepository;
	
	@Autowired
	private CandidateEmailBuilder candidateEmailBuilder;

	@Override
	public void addCandidateEmail(CandidateEmailDto candidateEmailDto) {
		//CandidateEmail candidateEmail = candidateEmailBuilder.toModel(candidateEmailDto);
		String sanitizedSubject = Jsoup.clean(candidateEmailDto.getBody(), Whitelist.none());
		String sanitizedSubject1 = Jsoup.clean(candidateEmailDto.getTitle(), Whitelist.none());
		String sanitizedSubject2 = Jsoup.clean(candidateEmailDto.getSubject(), Whitelist.none());
		CandidateEmail email=new CandidateEmail();
		email.setBody(sanitizedSubject);
		email.setTitle(sanitizedSubject1);
		email.setSubject(sanitizedSubject2);
		candidateEmailRepository.save(email);	
		
	}

	@Override
	public List<CandidateEmailDto> findAll() {
		List<CandidateEmailDto> candidateEmailDtos = new ArrayList<>();
		List<CandidateEmail> candidateEmails = candidateEmailRepository.findAll();
		if (candidateEmails != null) {
			candidateEmails.forEach(candidateEmail -> {
				candidateEmailDtos.add(candidateEmailBuilder.toDto(candidateEmail));
			});
		}
		return candidateEmailDtos;
	}

	@Override
	public void update(Long id, CandidateEmailDto candidateEmailDto) {
		Optional<CandidateEmail> dbCandidateEmail = candidateEmailRepository.findById(id);
		if(dbCandidateEmail.isPresent()) {
			
			//candidateEmailRepository.save(candidateEmailBuilder.toModel(candidateEmailDto));
			String sanitizedSubject = Jsoup.clean(candidateEmailDto.getBody(), Whitelist.none());
			String sanitizedSubject1 = Jsoup.clean(candidateEmailDto.getTitle(), Whitelist.none());
			String sanitizedSubject2 = Jsoup.clean(candidateEmailDto.getSubject(), Whitelist.none());
			CandidateEmail email=new CandidateEmail();
			email.setBody(sanitizedSubject);
			email.setTitle(sanitizedSubject1);
			email.setSubject(sanitizedSubject2);
			candidateEmailRepository.save(email);	
		}
	}

	@Override
	public void delete(Long id) {
		
		candidateEmailRepository.deleteById(id);
		
	}

}

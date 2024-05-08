package com.mentors.HiringProcess.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.CandidateBuilder;
import com.mentors.HiringProcess.builder.EmailTemplateBuilder;
import com.mentors.HiringProcess.builder.VendorBuilder;
import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.VendorDto;
import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.EmailTemplate;
import com.mentors.HiringProcess.repository.CandidateRepository;
import com.mentors.HiringProcess.repository.EmailTemplateRepository;
import com.mentors.HiringProcess.specification.CandidateSpecifications;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateServiceI {

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private CandidateBuilder candidateBuilder;

	@Autowired
	private EmailService emailService;

	@Autowired
	private EmailTemplateRepository emailTemplateRepository;

	@Autowired
	private EmailTemplateBuilder emailTemplateBuilder;

	@Autowired
	private EmailTemplateServiceImpl emailTemplateServiceImpl;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private VendorBuilder vendorBuilder;

	@Override
	public void add(CandidateDto candidateDto) {
		if (candidateRepository.findByEmail(candidateDto.getEmail()).isPresent()) {
			throw new RuntimeException("Email is Already Exit");
		}
		if (candidateRepository.findByMobile(candidateDto.getMobile()).isPresent()) {
			throw new RuntimeException("Mobile is Already Exit");
		}
		candidateDto.setCreatedTimestamp(LocalDateTime.now());
		candidateRepository.save(candidateBuilder.toModel(candidateDto));

		String candidateName = candidateDto.getFirstName();
		String uploadDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		EmailTemplate emailTemplate = emailTemplateRepository.findByTitle(candidateDto.getStage().toString());
		String body = emailTemplate.getBody();
		String updatedBody = body.replace("[CandidateName]", candidateName).replace("[UploadDate]", uploadDate);
		emailService.sendSimpleMessage(candidateDto.getEmail(), emailTemplate.getSubject(), updatedBody, null, null,
				null);
		
	}

	@Override
	public void update(Long id, CandidateDto candidateDto) {
		// TODO Auto-generated method stub
		Optional<Candidate> opCandidate = candidateRepository.findById(id);
		if (opCandidate.isPresent()) {
			candidateDto.setModifiedTimestamp(LocalDateTime.now());
			candidateRepository.save(candidateBuilder.toModel(candidateDto));
		}
	}

	@Override
	public List<CandidateDto> getAll() {
		// TODO Auto-generated method stub
		List<CandidateDto> candidateDtos = new ArrayList<>();
		List<Candidate> candidates = candidateRepository.findAll();
		if (candidates != null) {
			candidates.forEach(candidate -> {
				candidateDtos.add(candidateBuilder.toDto(candidate));
			});
		}
		return candidateDtos;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		candidateRepository.deleteById(id);
	}

	@Override
	public CandidateDto findOne(Long id) {
		// TODO Auto-generated method stub
		Optional<Candidate> dbaCandidate = candidateRepository.findById(id);
		if (dbaCandidate.isPresent()) {
			return candidateBuilder.toDto(dbaCandidate.get());
		} else {
			return null;
		}
	}

	// Filter Api for canidate
	public List<CandidateDto> getCandidatesByCriteria(String firstName, String lastName, String email) {
		List<CandidateDto> candidateDtoList = new ArrayList<>();
		List<Candidate> candidatelist = candidateRepository.findByCriteria(firstName, lastName, email);
		for (Candidate candidate : candidatelist) {
			CandidateDto candidateDto = candidateBuilder.toDto(candidate);
			candidateDtoList.add(candidateDto);

		}
		return candidateDtoList;
	}

	@Override
	public Page<CandidateDto> getAllCandidates(Pageable pageable, String code) {
		Specification<Candidate> spec = Specification.where(null); // Start with an empty specification

		if (code != null && !code.isEmpty()) {
			spec = spec.and(CandidateSpecifications.hasFields(code));
		}

		Page<Candidate> candidatePage = candidateRepository.findAll(spec, pageable);
		return candidatePage.map(candidateBuilder::toDto);
	}

	@Override
	public Page<CandidateDto> getAllCandidatesWithPagination(Pageable pageable) {
		Page<Candidate> recruiterPage = candidateRepository.findAll(pageable);
		return recruiterPage.map(candidateBuilder::toDto);
	}
	
	@Override
	public List<CandidateDto> getCandidatesByVendorId(Long vendorId) {
		// Retrieve the Vendor entity based on the vendorId
		Optional<VendorDto> vendorOptional = vendorService.findById(vendorId);
		VendorDto vendorDto = vendorOptional
				.orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + vendorId));

		// Retrieve candidates associated with the vendor
		List<Candidate> candidates = candidateRepository.findByVendor(vendorBuilder.toModel(vendorDto));

		// Convert the list of Candidate entities to a list of CandidateDto objects
		return candidates.stream().map(candidateBuilder::toDto).collect(Collectors.toList());
	}
	

}

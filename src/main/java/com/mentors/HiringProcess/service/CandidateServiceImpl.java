package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.CandidateBuilder;
import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.repository.CandidateRepository;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateServiceI {

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private CandidateBuilder candidateBuilder;

	@Override
	public void add(CandidateDto candidateDto) {
		if(candidateRepository.findByEmail(candidateDto.getEmail()).isPresent()) {
			throw new RuntimeException("Email is Already Exit");
		}
		if(candidateRepository.findByMobile(candidateDto.getMobile()).isPresent()) {
			throw new RuntimeException("Mobile is Already Exit");
		}
		candidateRepository.save(candidateBuilder.toModel(candidateDto));
	}

	@Override
	public void update(Long id, CandidateDto candidateDto) {
		// TODO Auto-generated method stub
		Optional<Candidate> opCandidate = candidateRepository.findById(id);
		if (opCandidate.isPresent()) {
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
		}else {
			return null;
		}
	}

}

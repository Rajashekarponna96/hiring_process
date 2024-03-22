package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.RecruiterBuilder;
import com.mentors.HiringProcess.dto.RecruiterDto;
import com.mentors.HiringProcess.model.Recruiter;
import com.mentors.HiringProcess.repository.RecruiterRepository;
import com.mentors.HiringProcess.specification.RecruiterSpecifications;


@Service
@Transactional
public class RecruiterServiceImpl implements RecruiterServiceI {

	@Autowired
	private RecruiterRepository recruiterRepository;

	@Autowired
	private RecruiterBuilder recruiterBuilder;

	@Override
	public void add(RecruiterDto recruiterDto) {
		if(recruiterRepository.findByEmail(recruiterDto.getEmail()).isPresent()) {
			throw new RuntimeException("Email is Already Exit");
		}
		if(recruiterRepository.findByMobile(recruiterDto.getMobile()).isPresent()) {
			throw new RuntimeException("Mobile is Already Exit");
		}
		recruiterRepository.save(recruiterBuilder.toModel(recruiterDto));
	}

	@Override
	public List<RecruiterDto> findAll() {
		// TODO Auto-generated method stub
		List<RecruiterDto> listDtos = new ArrayList<>();
		List<Recruiter> list = recruiterRepository.findAll();
		if (list != null) {
			list.forEach(recruiter -> {
				listDtos.add(recruiterBuilder.toDto(recruiter));
			});
		}
		return listDtos;
	}

	@Override
	public void update(Long id, RecruiterDto recruiterDto) {
		// TODO Auto-generated method stub
		Optional<Recruiter> dbRecruiter = recruiterRepository.findById(id);
		if (dbRecruiter.isPresent()) {
			recruiterRepository.save(recruiterBuilder.toModel(recruiterDto));
		}
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		recruiterRepository.deleteById(id);
	}
	
		
		@Override
	    public Page<RecruiterDto> getAllRecruiters(Pageable pageable, String code) {
	        Specification<Recruiter> spec = Specification.where(null); // Start with an empty specification

	        if (code != null && !code.isEmpty()) {
	            spec = spec.and(RecruiterSpecifications.hasFields(code));
	        }

	        Page<Recruiter> recruiterPage = recruiterRepository.findAll(spec, pageable);
	        return recruiterPage.map(recruiterBuilder::toDto);
	    }



}

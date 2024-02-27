package com.mentors.HiringProcess.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.TalentPoolBuilder;
import com.mentors.HiringProcess.dto.TalentPoolDto;
import com.mentors.HiringProcess.model.TalentPool;
import com.mentors.HiringProcess.repository.TalentPoolRepository;

@Service
@Transactional
public class TalentPoolServiceImpl implements TalentPoolServiceI {

	@Autowired
	private TalentPoolBuilder talentPoolBuilder;

	@Autowired
	private TalentPoolRepository talentPoolRepository;

	@Override
	public void add(TalentPoolDto talentPoolDto) {

		TalentPool talentPool = talentPoolRepository.findByName(talentPoolDto.getName());
		if (talentPool != null) {
			throw new RuntimeException("Talent Pool already exists.");
		}
		talentPoolRepository.save(talentPoolBuilder.toModel(talentPoolDto));
	}

	@Override
	public List<TalentPoolDto> findAll() {

		return talentPoolBuilder.toDtoList(talentPoolRepository.findAll());
	}

	@Override
	public void update(TalentPoolDto talentPoolDto,Long id) {
		Optional<TalentPool> dbTalentPool=talentPoolRepository.findById(id);
		if(dbTalentPool.isPresent()) {
	     TalentPool talentPool=talentPoolRepository.save(talentPoolBuilder.toModel(talentPoolDto));
		}
	  
		
	}

}

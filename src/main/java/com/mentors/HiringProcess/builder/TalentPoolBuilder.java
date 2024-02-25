package com.mentors.HiringProcess.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.TalentPoolDto;
import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.TalentPool;

@Component
public class TalentPoolBuilder {
	public TalentPool toModel(TalentPoolDto talentPoolDto) {

		TalentPool talentPool = new TalentPool();
		talentPool.setId(talentPoolDto.getId());
		talentPool.setName(talentPoolDto.getName());
		talentPool.setDescription(talentPoolDto.getDescription());

		return talentPool;
	}

	public TalentPoolDto toDto(TalentPool talentPool) {
		TalentPoolDto talentPoolDto = new TalentPoolDto();
		talentPoolDto.setId(talentPool.getId());
		talentPoolDto.setName(talentPool.getName());
		talentPoolDto.setDescription(talentPool.getDescription());

		List<CandidateDto> candidateDtos = new ArrayList<>();
		for (Candidate candidate : talentPool.getCandidates()) {
			CandidateDto candidateDto = new CandidateDto();
			candidateDto.setId(candidate.getId());
			candidateDtos.add(candidateDto);
		}
		talentPoolDto.setCandidates(candidateDtos);

		return talentPoolDto;
	}

}

package com.mentors.HiringProcess.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentors.HiringProcess.builder.HiringFlowActivityBuilder;
import com.mentors.HiringProcess.dto.HiringFlowActivityDto;
import com.mentors.HiringProcess.model.HiringFlowActivity;
import com.mentors.HiringProcess.repository.HiringFlowActivityRepository;

@Service
public class HiringFlowActivityService {

	@Autowired
	private HiringFlowActivityRepository hiringFlowActivityRepository;

	@Autowired
	private HiringFlowActivityBuilder hiringFlowActivityBuilder;

	@Autowired
	private HiringFlowActivity hiringFlowActivity; // Autowiring the HiringFlowActivity bean

	public List<HiringFlowActivityDto> getHiringFlowActivitiesByCandidateId(Long candidateId) {
		List<HiringFlowActivity> activities = hiringFlowActivityRepository.findByCandidateId(candidateId);
		return activities.stream().map(hiringFlowActivityBuilder::toDto)
				.sorted(Comparator.comparing(HiringFlowActivityDto::getCreatedDate)).collect(Collectors.toList());
	}

}
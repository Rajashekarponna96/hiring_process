package com.mentors.HiringProcess.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.HiringFlowActivityDto;
import com.mentors.HiringProcess.model.HiringFlowActivity;
@Component
public class HiringFlowActivityBuilder {
    @Autowired
    private UserAccoutBuilder userAccoutBuilder;

    @Autowired
    private CandidateBuilder candidateBuilder;

    public HiringFlowActivity toModel(HiringFlowActivityDto hiringFlowActivityDto) {
        HiringFlowActivity hiringFlowActivity = new HiringFlowActivity();
        hiringFlowActivity.setId(hiringFlowActivityDto.getId());
        hiringFlowActivity.setUserAccount(userAccoutBuilder.toModel(hiringFlowActivityDto.getUserAccount()));
        hiringFlowActivity.setCreatedDate(hiringFlowActivityDto.getCreatedDate());
        hiringFlowActivity.setHiringFlowType(hiringFlowActivityDto.getHiringFlowType()); // Assuming HiringFlowType is a simple enum

        // Set the candidate if available
        if (hiringFlowActivityDto.getCandidate() != null) {
            hiringFlowActivity.setCandidate(candidateBuilder.toModel(hiringFlowActivityDto.getCandidate()));
        }

        return hiringFlowActivity;
    }

    public HiringFlowActivityDto toDto(HiringFlowActivity hiringFlowActivity) {
        HiringFlowActivityDto hiringFlowActivityDto = new HiringFlowActivityDto();
        hiringFlowActivityDto.setId(hiringFlowActivity.getId());
        hiringFlowActivityDto.setUserAccount(userAccoutBuilder.toDto(hiringFlowActivity.getUserAccount()));
        hiringFlowActivityDto.setCreatedDate(hiringFlowActivity.getCreatedDate());
        hiringFlowActivityDto.setHiringFlowType(hiringFlowActivity.getHiringFlowType());

        // Set the candidate if available
        if (hiringFlowActivity.getCandidate() != null) {
            hiringFlowActivityDto.setCandidate(candidateBuilder.toDto(hiringFlowActivity.getCandidate()));
        }

        return hiringFlowActivityDto;
    }
}

 
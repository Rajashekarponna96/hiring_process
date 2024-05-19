package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.HiringFlowActivityDto;
import com.mentors.HiringProcess.service.HiringFlowActivityService;

@RestController
@RequestMapping("/hiringFlowActivities")
@CrossOrigin
public class HiringFlowActivityController {
	@Autowired
	private HiringFlowActivityService hiringFlowActivityService;

	 @GetMapping("/candidate/{candidateId}")
	    public ResponseEntity<List<HiringFlowActivityDto>> getHiringFlowActivitiesByCandidateId(
	            @PathVariable Long candidateId) {
	        List<HiringFlowActivityDto> activities = hiringFlowActivityService
	                .getHiringFlowActivitiesByCandidateId(candidateId);
	        if (activities.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(activities);
	    }
//	@GetMapping("/candidate/{candidateId}")
//	public ResponseEntity<List<HiringFlowActivity>> getHiringFlowActivitiesByCandidateId(
//			@PathVariable Long candidateId) {
//		List<HiringFlowActivity> activities = hiringFlowActivityService
//				.getHiringFlowActivitiesByCandidateId(candidateId);
//		if (activities.isEmpty()) {
//			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.ok(activities);
//	}
	

}

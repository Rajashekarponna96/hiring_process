package com.mentors.HiringProcess.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.ClientDto;
import com.mentors.HiringProcess.dto.HiringFlowDto;
import com.mentors.HiringProcess.dto.JobDto;
import com.mentors.HiringProcess.dto.LocationDto;
import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.Client;
import com.mentors.HiringProcess.model.HiringFlow;
import com.mentors.HiringProcess.model.Job;
import com.mentors.HiringProcess.model.Location;
@Component
public class JobBuilder {

	
	@Autowired
	private DepartmentBuilder departmentBuilder;
	
	@Autowired
	private  CurrencyTypeBuilder currencyTypeBuilder;
	
	@Autowired
    private RecruiterBuilder recruiterBuilder;
	
	@Autowired
	private ClientBuilder clientBuilder;
	
	public Job toModel(JobDto jobDto) {

		Job job = new Job();
		job.setId(jobDto.getId());
		job.setTitle(jobDto.getTitle());
		job.setDescription(jobDto.getDescription());
		job.setDepartment(departmentBuilder.toModel(jobDto.getDepartment()));
		job.setOpenings(jobDto.getOpenings());
		job.setTargetHireDate(jobDto.getTargetHireDate());
		job.setCurrney(currencyTypeBuilder.toModel(jobDto.getCurrney()));
//		job.setSalaryMinimum(jobDto.getSalaryMinimum());
		job.setSalaryMaximum(jobDto.getSalaryMaximum());
		job.setLocations(jobDto.getLocations());
		job.setType(jobDto.getType());
		job.setExperience(jobDto.getExperience());
		job.setRecruiters(recruiterBuilder.toModel(jobDto.getRecruiters()));
		job.setClients(clientBuilder.toModel(jobDto.getClients()));
		job.setExpectedNoticePeriod(jobDto.getExpectedNoticePeriod());
		job.setPrimarySkills(jobDto.getPrimarySkills());
		job.setSecondarySkills(jobDto.getSecondarySkills());
		job.setGoodToHave(jobDto.getGoodToHave());
		job.setCreatedTimestamp(jobDto.getCreatedTimestamp());
		job.setModifiedTimestamp(jobDto.getModifiedTimestamp());
		return job;
	}

	
	public JobDto toDto(Job job) {
		JobDto jobdto = new JobDto();
		jobdto.setId(job.getId());
		jobdto.setTitle(job.getTitle());
		jobdto.setDescription(job.getDescription());
		jobdto.setDepartment(departmentBuilder.toDto(job.getDepartment()));
		jobdto.setOpenings(job.getOpenings());
		jobdto.setTargetHireDate(job.getTargetHireDate());
		jobdto.setCurrney(currencyTypeBuilder.toDto(job.getCurrney()));
//		jobdto.setSalaryMinimum(job.getSalaryMinimum());
		jobdto.setSalaryMaximum(job.getSalaryMaximum());
		jobdto.setLocations(job.getLocations());
		jobdto.setType(job.getType());
		jobdto.setExperience(job.getExperience());
		jobdto.setRecruiters(recruiterBuilder.toDto(job.getRecruiters()));
		jobdto.setClients(clientBuilder.toDto(job.getClients()));
		jobdto.setExpectedNoticePeriod(job.getExpectedNoticePeriod());
		jobdto.setPrimarySkills(job.getPrimarySkills());
		jobdto.setSecondarySkills(job.getSecondarySkills());
		jobdto.setGoodToHave(job.getGoodToHave());
		jobdto.setCreatedTimestamp(job.getCreatedTimestamp());
		jobdto.setModifiedTimestamp(job.getModifiedTimestamp());
		
//		List<LocationDto> locationDtos = new ArrayList<>();
//	    for (Location location : job.getLocations()) {
//	    	LocationDto locationDto = new LocationDto();
//	    	locationDto.setId(location.getId());
//	    	locationDtos.add(locationDto);
//	    }
//	    jobdto.setLocations(locationDtos);
	    
	    List<HiringFlowDto> hiringFlowDtos = new ArrayList<>();
	    for (HiringFlow hiringFlow : job.getFlows()) {
	    	HiringFlowDto hiringFlowDto = new HiringFlowDto();
	    	hiringFlowDto.setId(hiringFlow.getId());
	    	hiringFlowDtos.add(hiringFlowDto);
	    }
	    jobdto.setFlows(hiringFlowDtos);
		
		List<CandidateDto> candidateDtos = new ArrayList<>();
	    for (Candidate candidate : job.getCandidates()) {
	        CandidateDto candidateDto = new CandidateDto();
	        candidateDto.setId(candidate.getId());
	        candidateDtos.add(candidateDto);
	    }
	    jobdto.setCandidates(candidateDtos);
	    
	    
//	    List<RecruiterDto> recruiterDtos = new ArrayList<>();
//	    for (Recruiter recruiter : job.getRecruiters()) {
//	    	RecruiterDto recruiterDto = new RecruiterDto();
//	    	recruiterDto.setId(recruiter.getId());
//	    	recruiterDtos.add(recruiterDto);
//	    }
//	    jobdto.setRecruiters(recruiterDtos);
	    
		return jobdto;
}
}

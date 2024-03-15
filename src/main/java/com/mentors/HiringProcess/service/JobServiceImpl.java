package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.JobBuilder;
import com.mentors.HiringProcess.dto.JobDto;
import com.mentors.HiringProcess.model.Job;
import com.mentors.HiringProcess.repository.JobRepository;

@Service
@Transactional
public class JobServiceImpl implements JobServiceI {

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private JobBuilder jobBuilder;

	@Override
	public void addJob(JobDto jobDto) {
		jobRepository.save(jobBuilder.toModel(jobDto));
	}

	@Override
	public List<JobDto> allJobs() {
		// TODO Auto-generated method stub
		List<JobDto> jobsList = new ArrayList<>();
		List<Job> jobs = jobRepository.findAll();
		if (jobs != null) {
			jobs.forEach(job -> {
				jobsList.add(jobBuilder.toDto(job));
			});
		}
		return jobsList;
	}

	@Override
	public void updateJob(Long id, JobDto jobDto) {
		// TODO Auto-generated method stub
		Optional<Job> dbJob = jobRepository.findById(id);
		if (dbJob.isPresent()) {
			jobRepository.save(jobBuilder.toModel(jobDto));
		}
	}

	@Override
	public void deleteJob(Long id) {
		// TODO Auto-generated method stub
		jobRepository.deleteById(id);
	}

}

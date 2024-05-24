package com.mentors.HiringProcess.service;

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

import com.mentors.HiringProcess.builder.JobBuilder;
import com.mentors.HiringProcess.dto.ClientDto;
import com.mentors.HiringProcess.dto.JobDto;
import com.mentors.HiringProcess.dto.JobSummaryDto;
import com.mentors.HiringProcess.model.Client;
import com.mentors.HiringProcess.model.Job;
import com.mentors.HiringProcess.model.Vendor;
import com.mentors.HiringProcess.repository.JobRepository;
import com.mentors.HiringProcess.repository.VendorRepository;
import com.mentors.HiringProcess.specification.JobSpecifications;

@Service
@Transactional
public class JobServiceImpl implements JobServiceI {

	@Autowired
	private JobRepository jobRepository;

	//
	@Autowired
	private VendorRepository vendorRepository;

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
	public List<JobSummaryDto> getAllJobSummaries() {
		List<JobSummaryDto> jobSummaries = new ArrayList<>();
		List<Job> jobs = jobRepository.findAll();
		if (jobs != null) {
			jobs.forEach(job -> {
				jobSummaries.add(new JobSummaryDto(job.getTitle(), job.getOpenings()));
			});
		}
		return jobSummaries;
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

	@Override
	public List<JobDto> allJobsWithClients() {
		List<Job> jobs = jobRepository.findAll();
		return jobs.stream().map(this::mapJobToJobDtoWithClient).collect(Collectors.toList());
	}

	private JobDto mapJobToJobDtoWithClient(Job job) {
		JobDto jobDto = new JobDto();
		jobDto = jobBuilder.toDto(job);
		// Map job attributes
//        jobDto.setId(job.getId());
//        jobDto.setTitle(job.getTitle());
//        jobDto.setDescription(job.getDescription());
//        jobDto.setOpenings(job.getOpenings());
//        
		// Map other job attributes...

		// Fetch client for the job
		Client client = job.getClients(); // Assuming there's a method to get the client associated with the job
		if (client != null) {
			ClientDto clientDto = new ClientDto();
			clientDto.setId(client.getId());
			clientDto.setCompanyName(client.getCompanyName());
			// Map other client attributes...

			jobDto.setClients(clientDto);
		}

		return jobDto;
	}

	@Override
	public Page<JobDto> getAllJobs(Pageable pageable, String code) {
		Specification<Job> spec = Specification.where(null); // Start with an empty specification

		if (code != null && !code.isEmpty()) {
			spec = spec.and(JobSpecifications.hasFields(code));
		}

		Page<Job> recruiterPage = jobRepository.findAll(spec, pageable);
		return recruiterPage.map(jobBuilder::toDto);

	}

	@Override
	public Page<JobDto> getAllJobsWithPagination(Pageable pageable) {
		Page<Job> jobPage = jobRepository.findAll(pageable);
		return jobPage.map(jobBuilder::toDto);

	}

	//
	@Override
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public List<Vendor> getAllVendors() {
		return vendorRepository.findAll();
	}

	@Override
	public void assignVendorToJob(Long jobId, Long vendorId) {
		if (jobId == null || vendorId == null) {
			throw new IllegalArgumentException("Job ID and Vendor ID must not be null");
		}

		Job job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));
		Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new RuntimeException("Vendor not found"));

		job.setVendor(vendor);
		jobRepository.save(job);
	}
}

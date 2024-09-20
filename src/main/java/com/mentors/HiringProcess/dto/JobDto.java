package com.mentors.HiringProcess.dto;

import java.time.LocalDate;
import java.util.List;

import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.CurrencyType;
import com.mentors.HiringProcess.model.Department;
import com.mentors.HiringProcess.model.HiringFlow;
import com.mentors.HiringProcess.model.JobType;
import com.mentors.HiringProcess.model.Location;
import com.mentors.HiringProcess.model.Recruiter;

public class JobDto {
	
private Long id;
	
	private String title;
	
	private String description;
	
	private DepartmentDto department;
	
	private long openings;
	
	private LocalDate targetHireDate;
	
	private CurrencyTypeDto currney;
	
	private Double salaryMinimum;

	private Double salaryMaximum;
	
	private JobType type;
	
	private String locations;
	
	private List<HiringFlowDto> flows;
	
	private String experience;
	
	private List<CandidateDto> candidates;
	
	private RecruiterDto recruiters;
	
	private ClientDto clients;
	
	private String expectedNoticePeriod;
	
    private String primarySkills;
	
	private String secondarySkills;
	
	private String goodToHave;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DepartmentDto getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}

	public long getOpenings() {
		return openings;
	}

	public void setOpenings(long openings) {
		this.openings = openings;
	}

	public LocalDate getTargetHireDate() {
		return targetHireDate;
	}

	public void setTargetHireDate(LocalDate targetHireDate) {
		this.targetHireDate = targetHireDate;
	}

	public CurrencyTypeDto getCurrney() {
		return currney;
	}

	public void setCurrney(CurrencyTypeDto currney) {
		this.currney = currney;
	}

	public Double getSalaryMinimum() {
		return salaryMinimum;
	}

	public void setSalaryMinimum(Double salaryMinimum) {
		this.salaryMinimum = salaryMinimum;
	}

	public Double getSalaryMaximum() {
		return salaryMaximum;
	}

	public void setSalaryMaximum(Double salaryMaximum) {
		this.salaryMaximum = salaryMaximum;
	}

	public JobType getType() {
		return type;
	}

	public void setType(JobType type) {
		this.type = type;
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	public List<HiringFlowDto> getFlows() {
		return flows;
	}

	public void setFlows(List<HiringFlowDto> flows) {
		this.flows = flows;
	}

	

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public List<CandidateDto> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<CandidateDto> candidates) {
		this.candidates = candidates;
	}

	public RecruiterDto getRecruiters() {
		return recruiters;
	}

	public void setRecruiters(RecruiterDto recruiters) {
		this.recruiters = recruiters;
	}
	

	

	public ClientDto getClients() {
		return clients;
	}

	public void setClients(ClientDto clients) {
		this.clients = clients;
	}
	
	

	public String getExpectedNoticePeriod() {
		return expectedNoticePeriod;
	}

	public void setExpectedNoticePeriod(String expectedNoticePeriod) {
		this.expectedNoticePeriod = expectedNoticePeriod;
	}
	
	

	public String getPrimarySkills() {
		return primarySkills;
	}

	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}

	public String getSecondarySkills() {
		return secondarySkills;
	}

	public void setSecondarySkills(String secondarySkills) {
		this.secondarySkills = secondarySkills;
	}

	public String getGoodToHave() {
		return goodToHave;
	}

	public void setGoodToHave(String goodToHave) {
		this.goodToHave = goodToHave;
	}

	public void validateRequiredAttibutes(JobDto jobDto) {
		if(jobDto.getTitle()==null) {
			throw new RuntimeException("Job Title is Mandatory");
		}
		if(jobDto.getDescription()==null) {
			throw new RuntimeException("Job Description is Mandatory");
		}
		if(jobDto.getDepartment()==null) {
			throw new RuntimeException("Department is Mandatory");
		}
		if (jobDto.getOpenings() <= 0) {
		    throw new RuntimeException("Openings must be a positive number");
		}
		if(jobDto.getTargetHireDate()==null) {
			throw new RuntimeException("TargetHireDate is Mandatory");
		}
		if(jobDto.getCurrney()==null) {
			throw new RuntimeException("Currency is Mandatory");
		}
//		if(jobDto.getSalaryMinimum()==null) {
//			throw new RuntimeException("SalaryMinimum is Mandatory");
//		}
		if(jobDto.getSalaryMaximum()==null) {
			throw new RuntimeException("SalaryMaximum is Mandatory");
		}
		if(jobDto.getType()==null) {
			throw new RuntimeException("JobType is Mandatory");
		}
		if(jobDto.getExperience()==null) {
			throw new RuntimeException("Experience is Mandatory");
		}
		if(jobDto.getRecruiters()==null) {
			throw new RuntimeException("Recruiter is Mandatory");
		}
		if(jobDto.getExpectedNoticePeriod()==null) {
			throw new RuntimeException("ExpectedNoticePeriod is Mandatory");
		}
	}
	

	
	
}

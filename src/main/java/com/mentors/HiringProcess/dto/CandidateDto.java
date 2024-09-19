package com.mentors.HiringProcess.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.mentors.HiringProcess.model.CurrencyType;
import com.mentors.HiringProcess.model.Education;
import com.mentors.HiringProcess.model.Experience;
import com.mentors.HiringProcess.model.Gender;
import com.mentors.HiringProcess.model.HiringFlowActivity;
import com.mentors.HiringProcess.model.HiringFlowType;
import com.mentors.HiringProcess.model.Job;
import com.mentors.HiringProcess.model.Location;
import com.mentors.HiringProcess.model.Source;
import com.mentors.HiringProcess.model.TalentPool;
import com.mentors.HiringProcess.model.UserAccout;

public class CandidateDto {
	private Long id;

	private String firstName;
	
	private String lastName;
	
//	private String middleName;
	
	private String email;
	
	private String mobile;
	
	private String alterMobile;
	
	private SourceDto source;
	
	private HiringFlowType stage;
	
	private LocationDto current;
	
	private String avialToJoin;
	
	private LocationDto preferred;
	
	private Double currentSalary;
	
	private Double expectedSalary;
	
	private CurrencyTypeDto  currency;
	
	private Gender gender;
	
	private LocalDate dateOfBirth;
	
	private List<String> skills;
	
	private List<ExperienceDto> experiences;
	
	private List<EducationDto> educations;
	
	private TalentPoolDto talentPool;
	
	private JobDto job;
	

	private UserAccoutDto createdBy;

	private VendorDto vendor;
	
	
	private UserAccoutDto modifiedBy;
    
    private LocalDateTime createdTimestamp;
    
    private LocalDateTime modifiedTimestamp;
    
    private List<HiringFlowActivityDto> HiringFlowActivity;
    
    private boolean status;
    
    private UserAccoutDto userAccout;
    
    private String fileName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public String getMiddleName() {
//		return middleName;
//	}
//
//	public void setMiddleName(String middleName) {
//		this.middleName = middleName;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getAlterMobile() {
		return alterMobile;
	}

	public void setAlterMobile(String alterMobile) {
		this.alterMobile = alterMobile;
	}

	public SourceDto getSource() {
		return source;
	}

	public void setSource(SourceDto source) {
		this.source = source;
	}

	

	public HiringFlowType getStage() {
		return stage;
	}

	public void setStage(HiringFlowType stage) {
		this.stage = stage;
	}

	public LocationDto getCurrent() {
		return current;
	}

	public void setCurrent(LocationDto current) {
		this.current = current;
	}

	

	public String getAvialToJoin() {
		return avialToJoin;
	}

	public void setAvialToJoin(String avialToJoin) {
		this.avialToJoin = avialToJoin;
	}

	public LocationDto getPreferred() {
		return preferred;
	}

	public void setPreferred(LocationDto preferred) {
		this.preferred = preferred;
	}

	public Double getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(Double currentSalary) {
		this.currentSalary = currentSalary;
	}

	public Double getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(Double expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public CurrencyTypeDto getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyTypeDto currency) {
		this.currency = currency;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<ExperienceDto> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<ExperienceDto> experiences) {
		this.experiences = experiences;
	}

	public List<EducationDto> getEducations() {
		return educations;
	}

	public void setEducations(List<EducationDto> educations) {
		this.educations = educations;
	}

	public TalentPoolDto getTalentPool() {
		return talentPool;
	}

	public void setTalentPool(TalentPoolDto talentPool) {
		this.talentPool = talentPool;
	}

	public JobDto getJob() {
		return job;
	}

	public void setJob(JobDto job) {
		this.job = job;
	}
	


	public UserAccoutDto getCreatedBy() {
   		return createdBy;
	}
	
	
	public VendorDto getVendor() {
		return vendor;
	}

	public void setVendor(VendorDto vendor) {
		this.vendor = vendor;
	}





	public void setCreatedBy(UserAccoutDto createdBy) {
		this.createdBy = createdBy;
	}

	public UserAccoutDto getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(UserAccoutDto modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public List<HiringFlowActivityDto> getHiringFlowActivity() {
		return HiringFlowActivity;
	}

	public void setHiringFlowActivity(List<HiringFlowActivityDto> hiringFlowActivity) {
		HiringFlowActivity = hiringFlowActivity;
	}

	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public LocalDateTime getModifiedTimestamp() {
		return modifiedTimestamp;
	}

	public void setModifiedTimestamp(LocalDateTime modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}
	
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

	
	public UserAccoutDto getUserAccout() {
		return userAccout;
	}

	public void setUserAccout(UserAccoutDto userAccout) {
		this.userAccout = userAccout;
	}
	
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void validateREquiredAttibutes(CandidateDto candidateDto) {
		if(candidateDto.getFirstName()==null) {
			throw new RuntimeException("FirstName is Mandatory");
		}
		if(candidateDto.getLastName()==null) {
			throw new RuntimeException("LastName is Mandatory");
		}
//		if(candidateDto.getMiddleName()==null) {
//			throw new RuntimeException("MiddleName is Mandatory");
//		}
		if(candidateDto.getMobile()==null) {
			throw new RuntimeException("Mobile is Mandatory");
		}
		if(candidateDto.getAlterMobile()==null) {
			throw new RuntimeException("AlternateMobile is Mandatory");
		}
//		if(candidateDto.getStage()==null) {
//			throw new RuntimeException("HiringStage is Mandatory");
//		}
		if(candidateDto.getAvialToJoin()==null) {
			throw new RuntimeException("NoticePeriod is Mandatory");
		}
		if(candidateDto.getCurrentSalary()==null) {
			throw new RuntimeException("CurrentSalary is Mandatory");
		}
		if(candidateDto.getExpectedSalary()==null) {
			throw new RuntimeException("ExpectedSalary is Mandatory");
		}
		if(candidateDto.getGender()==null) {
			throw new RuntimeException("Gender is Mandatory");
		}
//		if(candidateDto.getDateOfBirth()==null) {
//			throw new RuntimeException("DateOfBirth is Mandatory");
//		}
//		if(candidateDto.getTalentPool()==null) {
//			throw new RuntimeException("TalentPool is Mandatory");
//		}
		if(candidateDto.getJob()==null) {
			throw new RuntimeException("Job is Mandatory");
		}
		if(candidateDto.getSource()==null) {
			throw new RuntimeException("Source is Mandatory");
		}
		if(candidateDto.getCurrent()==null) {
			throw new RuntimeException("Current Location is Mandatory");
		}
		if(candidateDto.getPreferred()==null) {
			throw new RuntimeException("Preffered Location is Mandatory");
		}
//		if(candidateDto.getCurrency()==null) {
//			throw new RuntimeException("Currency is Mandatory");
//		}
//		if(skills== null || skills.isEmpty()) {
//			throw new RuntimeException("Skills is Mandatory");
//		}
		if (educations == null || educations.isEmpty()) {
            throw new RuntimeException("At least one Education is required");
        }
		if (experiences == null || experiences.isEmpty()) {
            throw new RuntimeException("At least one Experience is required");
        }
	}

}

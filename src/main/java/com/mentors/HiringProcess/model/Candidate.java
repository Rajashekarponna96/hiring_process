package com.mentors.HiringProcess.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mentors.HiringProcess.converter.StringListConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="candidate")
public class Candidate  implements Serializable {
	
	
	private Long id;

	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	private String email;
	
	private String mobile;
	
	private String alterMobile;
	
	private Source source;
	
	private HiringFlowType stage;
	
	private Location current;
	
	private String avialToJoin;
	
	private Location preferred;
	
	private Double currentSalary;
	
	private Double expectedSalary;
	
	private CurrencyType  currency;
	
	private Gender gender;
	
	private LocalDate dateOfBirth;
	
	private List<String> skills;
	
	private List<Experience> experiences;
	
	private List<Education> educations;
	
	private TalentPool talentPool;
	
	private Job job;
	
	//private UserAccout createdBy;
	
    private UserAccout modifiedBy;
    
    private LocalDateTime createdTimestamp;
    
    private LocalDateTime modifiedTimestamp;
    
    private List<HiringFlowActivity> HiringFlowActivity;
  
    private Vendor vendor;
    
    private boolean status;
    
    
//    public Candidate() {
//        this.createdTimestamp = LocalDateTime.now();
//        this.modifiedTimestamp = LocalDateTime.now();
//    }

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
     
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
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

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "source_id", referencedColumnName = "id")
	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}
	@Enumerated
	public HiringFlowType getStage() {
		return stage;
	}

	public void setStage(HiringFlowType stage) {
		this.stage = stage;
	}
   
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "current_location_id", referencedColumnName = "id")
	public Location getCurrent() {
		return current;
	}

	public void setCurrent(Location current) {
		this.current = current;
	}
    
	
	public String getAvialToJoin() {
		return avialToJoin;
	}

	public void setAvialToJoin(String avialToJoin) {
		this.avialToJoin = avialToJoin;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "preferred_location_id", referencedColumnName = "id")
	public Location getPreferred() {
		return preferred;
	}

	public void setPreferred(Location preferred) {
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
	@ManyToOne
	@JoinColumn(name="currencytype_id",referencedColumnName = "id")
	public CurrencyType getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyType currency) {
		this.currency = currency;
	}
	@Enumerated
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
	@Convert(converter = StringListConverter.class)
	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	@JsonIgnore
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}
	@JsonIgnore
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "talentpool_id")
	public TalentPool getTalentPool() {
		return talentPool;
	}

	public void setTalentPool(TalentPool talentPool) {
		this.talentPool = talentPool;
	}
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="job_id")
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

//	@JsonIgnore
//	@ManyToOne(cascade = CascadeType.ALL)
//	public UserAccout getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(UserAccout createdBy) {
//		this.createdBy = createdBy;
//	}
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	public UserAccout getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(UserAccout modifiedBy) {
		this.modifiedBy = modifiedBy;
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
	public List<HiringFlowActivity> getHiringFlowActivity() {
		return HiringFlowActivity;
	}

	public void setHiringFlowActivity(List<HiringFlowActivity> hiringFlowActivity) {
		HiringFlowActivity = hiringFlowActivity;
	}
  
  @JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "vendor_id")
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
	
	

}

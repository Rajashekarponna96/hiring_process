package com.mentors.HiringProcess.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="vendor")
public class Vendor  implements Serializable{
	
    private long id;
	
	private String vendorName;
	
	private String location;
	
    private String email;
	
	private String mobile;
	
	private UserAccout userAccout;
	
    private List<Job> jobs;
    
    private LocalDateTime createdTimestamp;
    
    private LocalDateTime modifiedTimestamp;

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "useraccount_id", referencedColumnName = "id")
	public UserAccout getUserAccout() {
		return userAccout;
	}

	public void setUserAccout(UserAccout userAccout) {
		this.userAccout = userAccout;
	}
    
	@JsonIgnore
    @ManyToMany(mappedBy = "vendors")
	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
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
	
	
	
	
	

}

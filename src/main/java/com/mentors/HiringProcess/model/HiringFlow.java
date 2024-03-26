package com.mentors.HiringProcess.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="hiring_flow")
public class HiringFlow  implements Serializable{
    
	
	private Long id;
	
	private HiringFlowType type;
	
	private String description;
	
	private Flow source;
	
	private Job job;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Enumerated
	public HiringFlowType getType() {
		return type;
	}

	public void setType(HiringFlowType type) {
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="flow_id",referencedColumnName = "id")
	public Flow getSource() {
		return source;
	}

	public void setSource(Flow source) {
		this.source = source;
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
	
}

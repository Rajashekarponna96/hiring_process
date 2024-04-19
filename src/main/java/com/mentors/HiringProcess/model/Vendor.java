package com.mentors.HiringProcess.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="vendor")
public class Vendor  implements Serializable{
	
    private long id;
	
	private String vendorName;
	
	private List<Poc> pocs;
	
	private String location;
	
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
	@JsonIgnore
	@OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
	public List<Poc> getPocs() {
		return pocs;
	}

	public void setPocs(List<Poc> pocs) {
		this.pocs = pocs;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
	

}

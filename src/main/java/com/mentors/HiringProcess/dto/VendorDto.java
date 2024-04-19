package com.mentors.HiringProcess.dto;

import java.util.List;

import com.mentors.HiringProcess.model.Poc;

public class VendorDto {
	
private long id;
	
	private String vendorName;
	
	private List<PocDto> pocs;
	
	private String location;

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

	

	public List<PocDto> getPocs() {
		return pocs;
	}

	public void setPocs(List<PocDto> pocs) {
		this.pocs = pocs;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public void validateRequiredAttibutes(VendorDto vendorDto) {
		if(vendorDto.getVendorName()!=null && vendorDto.getVendorName().isEmpty()) {
			throw  new RuntimeException("Vendor name is  Mandatory");
		}
		if(vendorDto.getLocation()!=null && vendorDto.getLocation().isEmpty()) {
			throw new RuntimeException("Location is Mandatory");
		}
		if (pocs != null && pocs.isEmpty()) {
            throw new RuntimeException("At least one Point of Contact is required");
        }
	}

}

package com.mentors.HiringProcess.service;

import java.util.List;

import com.mentors.HiringProcess.dto.VendorDto;

public interface VendorService {
	
	void addVendor(VendorDto vendorDto);
	
	List<VendorDto> allVendors();
	
	void updateClient(Long id, VendorDto vendorDto);
	
	void deleteVendor(Long id);

}

package com.mentors.HiringProcess.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mentors.HiringProcess.dto.ClientDto;
import com.mentors.HiringProcess.dto.VendorDto;

public interface VendorService {
	
	void addVendor(VendorDto vendorDto);
	
	List<VendorDto> allVendors();
	
	void updateClient(Long id, VendorDto vendorDto);
	
	void deleteVendor(Long id);
	
	Page<VendorDto> getAllClients(Pageable pageable, String code);

}

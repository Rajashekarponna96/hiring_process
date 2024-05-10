package com.mentors.HiringProcess.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.VendorDto;

public interface VendorService {

	void addVendor(VendorDto vendorDto);

	List<VendorDto> allVendors();

	void updateClient(Long id, VendorDto vendorDto);

	void deleteVendor(Long id);

	Page<VendorDto> getAllClients(Pageable pageable, String code);

	Page<VendorDto> getAllLientsWithPagination(Pageable pageable);

	List<VendorDto> getVendorsByUserAccountId(Long userAccountId);

	VendorDto getVendorByUserAccountId(Long userAccountId);

	List<CandidateDto> getCandidatesByVendor(Long vendorId);

	Optional<VendorDto> findById(Long vendorId);
	
	Page<CandidateDto>  getAllLientsWithPagination(Pageable pageable,Long vendorId);
	
	Page<CandidateDto> getCandidatesByVendor(Long vendorId,Pageable pageable);
	
	

}

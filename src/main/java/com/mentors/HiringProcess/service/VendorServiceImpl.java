package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.VendorBuilder;
import com.mentors.HiringProcess.dto.VendorDto;
import com.mentors.HiringProcess.model.Client;
import com.mentors.HiringProcess.model.Vendor;
import com.mentors.HiringProcess.repository.VendorRepository;
import com.mentors.HiringProcess.specification.ClientSprecifications;
import com.mentors.HiringProcess.specification.VendorSpecifications;
@Service
@Transactional
public class VendorServiceImpl  implements VendorService{
	@Autowired
	VendorRepository vendorRepository;
	@Autowired
	VendorBuilder vendorBuilder;

	@Override
	public void addVendor(VendorDto vendorDto) {
		
		vendorRepository.save(vendorBuilder.toModel(vendorDto));
	}

	@Override
	public List<VendorDto> allVendors() {
		List<VendorDto> vendorList = new ArrayList<>();
		List<Vendor> vendors = vendorRepository.findAll();
		if (vendors != null) {
			vendors.forEach(vendor -> {
				vendorList.add(vendorBuilder.toDto(vendor));
			});
		}
		return vendorList;
	}

	@Override
	public void updateClient(Long id, VendorDto vendorDto) {
		Optional<Vendor> dbVendor = vendorRepository.findById(id);
		if (dbVendor.isPresent()) {
			vendorRepository.save(vendorBuilder.toModel(vendorDto));
		}
		
	}

	@Override
	public void deleteVendor(Long id) {
		vendorRepository.deleteById(id);
		
	}

	@Override
	public Page<VendorDto> getAllClients(Pageable pageable, String code) {
		Specification<Vendor> spec = Specification.where(null); // Start with an empty specification

        if (code != null && !code.isEmpty()) {
            spec = spec.and(VendorSpecifications.hasFields(code));
        }

        Page<Vendor> recruiterPage = vendorRepository.findAll(spec, pageable);
        return recruiterPage.map(vendorBuilder::toDto);
	}

	@Override
	public Page<VendorDto> getAllLientsWithPagination(Pageable pageable) {
		Page<Vendor> recruiterPage = vendorRepository.findAll(pageable);
        return recruiterPage.map(vendorBuilder::toDto);
		
		
	}
	
	

}

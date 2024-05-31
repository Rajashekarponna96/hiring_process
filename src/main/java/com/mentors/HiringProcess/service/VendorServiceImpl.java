package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.CandidateBuilder;
import com.mentors.HiringProcess.builder.UserAccoutBuilder;
import com.mentors.HiringProcess.builder.VendorBuilder;
import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.VendorDto;
import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.Role;
import com.mentors.HiringProcess.model.UserAccout;
import com.mentors.HiringProcess.model.Vendor;
import com.mentors.HiringProcess.repository.CandidateRepository;
import com.mentors.HiringProcess.repository.RoleRepository;
import com.mentors.HiringProcess.repository.UserAccoutRepository;
import com.mentors.HiringProcess.repository.VendorRepository;
import com.mentors.HiringProcess.specification.VendorSpecifications;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {
	@Autowired
	VendorRepository vendorRepository;
	@Autowired
	VendorBuilder vendorBuilder;

	@Autowired
	CandidateBuilder candidateBuilder;

	@Autowired
	CandidateRepository candidateRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserAccoutBuilder userAccoutBuilder;
	
	@Autowired
	UserAccoutRepository userAccoutRepository;

	@Override
	public void addVendor(VendorDto vendorDto) {
		
		UserAccout userAccout= new UserAccout();
		List<Role> roles=roleRepository.findAll();
		
		Role role = roles.stream()
                .filter(r -> r.getName().equals("vendor"))
                .findFirst()
                .orElse(null);
		
		userAccout.setRole(role);
		userAccout.setUserName(vendorDto.getEmail());
		userAccout.setPassword(vendorDto.getMobile());
		userAccout.setActive(true);
		vendorDto.setUserAccout(userAccoutBuilder.toDto(userAccout));
        
		vendorRepository.saveAndFlush(vendorBuilder.toModel(vendorDto));

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
			Long userId = dbVendor.get().getUserAccout().getId();
	        Optional<UserAccout> userAccout= userAccoutRepository.findById(userId);
	        if(userAccout.isPresent()) {
	        	UserAccout updateUserAccout =userAccout.get();
	        	updateUserAccout.setUserName(vendorDto.getEmail());
	        	updateUserAccout.setPassword(vendorDto.getMobile());
	        	updateUserAccout.setActive(userAccout.get().isActive());
	        	updateUserAccout.setRole(userAccout.get().getRole());
	        	updateUserAccout.setCandidate(userAccout.get().getCandidate());
	        	vendorDto.setUserAccout(userAccoutBuilder.toDto(updateUserAccout));
	        	}
			
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

	@Override
	public VendorDto getVendorByUserAccountId(Long userAccountId) {
		Vendor vendor = vendorRepository.findByUserAccoutId(userAccountId);
		if (vendor != null) {
			return vendorBuilder.toDto(vendor);
		} else {
			return null; // or throw an exception if needed
		}
	}

	@Override
	public List<VendorDto> getVendorsByUserAccountId(Long userAccountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CandidateDto> getCandidatesByVendor(Long vendorId) {
		// Retrieve the Vendor entity based on the vendorId
		Vendor vendor = vendorRepository.findById(vendorId)
				.orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + vendorId));

		// Retrieve candidates associated with the vendor
		List<Candidate> candidates = candidateRepository.findByVendor(vendor);

		// Convert the list of Candidate entities to a list of CandidateDto objects
		return candidates.stream().map(candidateBuilder::toDto).collect(Collectors.toList());
	}

	@Override
	public Optional<VendorDto> findById(Long vendorId) {
		Optional<Vendor> vendorOptional = vendorRepository.findById(vendorId);
		return vendorOptional.map(vendorBuilder::toDto);
	}

	@Override
	public Page<CandidateDto> getAllLientsWithPagination(Pageable pageable, Long vendorId) {
		
		return null;
		
		
	}

	@Override
	public Page<CandidateDto> getCandidatesByVendor(Long vendorId, Pageable pageable) {
Page<Candidate> candidatesPage = candidateRepository.findByVendorId(vendorId, pageable);
        
        // Convert Page<Candidate> to Page<CandidateDto>
       
            return candidatesPage.map(candidateBuilder::toDto);
       

       
	}
	
	

}

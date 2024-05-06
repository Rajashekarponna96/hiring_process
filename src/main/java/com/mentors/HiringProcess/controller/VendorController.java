package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.VendorDto;
import com.mentors.HiringProcess.service.VendorService;

@RestController
@RequestMapping(value = "/vendor")
@CrossOrigin
public class VendorController {
	@Autowired
	VendorService vendorService;

	@PostMapping("/")
	public void addVendor(@RequestBody VendorDto vendorDto) {
		vendorDto.validateRequiredAttibutes(vendorDto);
		vendorService.addVendor(vendorDto);
	}

	@GetMapping("/all")
	public List<VendorDto> allClients() {
		return vendorService.allVendors();
	}

	@PutMapping("/{id}")
	public void updateVendor(@PathVariable Long id, @RequestBody VendorDto vendorDto) {
		vendorService.updateClient(id, vendorDto);
	}

	@DeleteMapping("/{id}")
	public void deleteVendor(@PathVariable Long id) {
		vendorService.deleteVendor(id);
	}

	@GetMapping("/searchpage")
	public Page<VendorDto> getAllLients(@RequestParam int page, @RequestParam int size, @RequestParam String code) {
		Pageable pageable = PageRequest.of(page, size);
		return vendorService.getAllClients(pageable, code);
	}

	// Vendor list with pagination
	@GetMapping("/vendorlistwithpagination")
	public Page<VendorDto> getAllLientsWithPagination(@RequestParam int page, @RequestParam int size) {
		Pageable pageable = PageRequest.of(page, size);
		return vendorService.getAllLientsWithPagination(pageable);
	}

	@GetMapping("/user/{userAccountId}")
	public ResponseEntity<?> getVendorByUserAccountId(@PathVariable Long userAccountId) {
		VendorDto vendor = vendorService.getVendorByUserAccountId(userAccountId);
		if (vendor != null) {
			return ResponseEntity.ok(vendor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	// Endpoint to get candidates by vendor ID
    @GetMapping("/{vendorId}")
    public ResponseEntity<List<CandidateDto>> getCandidatesByVendorId(@PathVariable Long vendorId) {
        List<CandidateDto> candidates = vendorService.getCandidatesByVendor(vendorId);
        return ResponseEntity.ok(candidates);
    }
}

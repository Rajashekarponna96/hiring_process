package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.ClientDto;
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
	public void updateVendor(@PathVariable Long id,  @RequestBody VendorDto  vendorDto) {
		vendorService.updateClient(id,vendorDto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteVendor(@PathVariable Long id) {
		vendorService.deleteVendor(id);
	}

}
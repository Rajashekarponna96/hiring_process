package com.mentors.HiringProcess.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.VendorDto;
import com.mentors.HiringProcess.model.Vendor;

@Component
public class VendorBuilder {

	@Autowired
	private UserAccoutBuilder userAccoutBuilder;

	public Vendor toModel(VendorDto vendorDto) {

		Vendor vendor = new Vendor();

		vendor.setId(vendorDto.getId());
		vendor.setVendorName(vendorDto.getVendorName());
		vendor.setLocation(vendorDto.getLocation());
		vendor.setEmail(vendorDto.getEmail());
		vendor.setMobile(vendorDto.getMobile());
		vendor.setUserAccout(userAccoutBuilder.toModel(vendorDto.getUserAccout()));
		return vendor;
	}

	public VendorDto toDto(Vendor vendor) {
		VendorDto vendorDto = new VendorDto();
		vendorDto.setId(vendor.getId());
		vendorDto.setVendorName(vendor.getVendorName());
		vendorDto.setLocation(vendor.getLocation());
		vendorDto.setEmail(vendor.getEmail());
		vendorDto.setMobile(vendor.getMobile());
		vendorDto.setUserAccout(userAccoutBuilder.toDto(vendor.getUserAccout()));
		return vendorDto;
	}

}

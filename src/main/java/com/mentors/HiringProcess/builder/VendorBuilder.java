package com.mentors.HiringProcess.builder;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.VendorDto;
import com.mentors.HiringProcess.model.Vendor;

@Component
public class VendorBuilder {
	
	@Autowired
	private PocBuilder pocBuilder;
	
	public Vendor toModel(VendorDto vendorDto) {
		
		Vendor vendor = new Vendor();
		
		vendor.setId(vendorDto.getId());
		vendor.setVendorName(vendorDto.getVendorName());
		vendor.setLocation(vendorDto.getLocation());
		vendor.setPocs(pocBuilder.toModelList(vendorDto.getPocs()).stream().peek(e->e.setVendor(vendor)).collect(Collectors.toList()));
		
		return vendor ;
	}
	
	public VendorDto toDto(Vendor vendor) {
		VendorDto vendorDto = new VendorDto();
		vendorDto.setId(vendor.getId());
		vendorDto.setVendorName(vendor.getVendorName());
		vendorDto.setLocation(vendor.getLocation());
		vendorDto.setPocs(pocBuilder.toDtoList(vendor.getPocs()));
		return vendorDto;
	}

}

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

import com.mentors.HiringProcess.dto.LocationDto;
import com.mentors.HiringProcess.service.LocationServiceI;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/location")
@CrossOrigin
public class LocationController {
	
	@Autowired
	private LocationServiceI locationServiceI;
	
	@PostMapping("/add")
	public void addLocation(@RequestBody LocationDto locationDto) {
		locationServiceI.addLocation(locationDto);
	}
	
	@GetMapping("/all")
	public List<LocationDto> allLocations() {
		return locationServiceI.allLocations();
	}
	
	@PutMapping(value = "/{id}")
	public void updateLocation(@PathVariable Long id, @RequestBody LocationDto location) {
		locationServiceI.updateLocation(id,location);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteLocation(@PathVariable Long id) {
		locationServiceI.deleteLocation(id);
	}
	

}

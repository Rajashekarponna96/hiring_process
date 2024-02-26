package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.LocationBuilder;
import com.mentors.HiringProcess.dto.LocationDto;
import com.mentors.HiringProcess.model.Location;
import com.mentors.HiringProcess.repository.LocationRepository;

@Service
@Transactional
public class LocationServiceImpl implements LocationServiceI {

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private LocationBuilder locationBuilder;

	@Override
	public void addLocation(LocationDto locationDto) {
		// TODO Auto-generated method stub
		Location location = locationBuilder.toModel(locationDto);
		locationRepository.save(location);
	}

	@Override
	public List<LocationDto> allLocations() {
		// TODO Auto-generated method stub
		List<LocationDto> locationDtos = new ArrayList<>();
		List<Location> locations = locationRepository.findAll();
		if (locations != null) {
			locations.forEach(location -> {
				locationDtos.add(locationBuilder.toDto(location));
			});
		}
		return locationDtos;
	}

	@Override
	public void updateLocation(Long id, LocationDto location) {
		// TODO Auto-generated method stub
		Optional<Location> dbLocation = locationRepository.findById(id);
		if(dbLocation.isPresent()) {
			locationRepository.save(locationBuilder.toModel(location));
		}
	}

	@Override
	public void deleteLocation(Long id) {
		// TODO Auto-generated method stub
		locationRepository.deleteById(id);
	}

}

package com.mentors.HiringProcess.service;

import java.util.List;

import com.mentors.HiringProcess.dto.LocationDto;

public interface LocationServiceI {

	void addLocation(LocationDto locationDto);

	List<LocationDto> allLocations();

	void updateLocation(Long id, LocationDto location);

	void deleteLocation(Long id);

}

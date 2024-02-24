package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.LocationDto;
import com.mentors.HiringProcess.model.Location;
@Component
public class LocationBuilder {
	public Location toModel(LocationDto locationDto) {

		Location location = new Location();
		location.setId(locationDto.getId());
		location.setName(locationDto.getName());
		location.setCode(locationDto.getCode());
		
		return location;
	}

	
	public LocationDto toDto(Location location) {
		LocationDto locationDto = new LocationDto();
		locationDto.setName(location.getName());
		locationDto.setCode(location.getCode());
		return locationDto;
}

}

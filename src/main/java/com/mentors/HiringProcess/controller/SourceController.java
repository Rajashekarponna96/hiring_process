package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.SourceDto;
import com.mentors.HiringProcess.service.SourceService;

@RestController
@RequestMapping(value="/source")
public class SourceController {
	@Autowired
	private SourceService sourceService;
	
	
	@GetMapping(value="/all")
	public List<SourceDto> getAll(){
		return sourceService.getAll();
	}
	

}

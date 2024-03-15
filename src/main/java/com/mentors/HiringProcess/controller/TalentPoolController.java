package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.TalentPoolDto;
import com.mentors.HiringProcess.service.TalentPoolServiceI;



@RestController
@RequestMapping(value = "/talentPool")
@CrossOrigin
public class TalentPoolController {

	@Autowired
	private TalentPoolServiceI talentPoolServiceI;

	@PostMapping("/")
	public void add(@RequestBody TalentPoolDto talentPoolDto) {
		talentPoolDto.validateRequiredAttibutes(talentPoolDto);
		talentPoolServiceI.add(talentPoolDto);

	}
	@GetMapping("/all")
	public List<TalentPoolDto> findAll(){
		return talentPoolServiceI.findAll();
	}
	@PutMapping(value="/{id}")
	public void update(@RequestBody TalentPoolDto talentPoolDto,@PathVariable Long id) {
		talentPoolServiceI.update(talentPoolDto,id);
	}

}

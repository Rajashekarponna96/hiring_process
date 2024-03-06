package com.mentors.HiringProcess.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentors.HiringProcess.dto.CurrencyTypeDto;
import com.mentors.HiringProcess.model.CurrencyType;
import com.mentors.HiringProcess.service.CurrencyTypeService;

@RestController
@RequestMapping(value="/currency")
@CrossOrigin
public class CurrencyTypeController {
	@Autowired
	CurrencyTypeService currencyTypeService;
	
	@GetMapping(value="/all")  
	public List<CurrencyTypeDto> getAllCurrencyList(){
		return currencyTypeService.getAll();
	}
	
	

}

package com.mentors.HiringProcess.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.CurrencyTypeBuilder;
import com.mentors.HiringProcess.dto.CurrencyTypeDto;
import com.mentors.HiringProcess.model.CurrencyType;
import com.mentors.HiringProcess.repository.CurrencyTypeRepository;

@Service
@Transactional
public class CurrencyTypeServiceImpl implements CurrencyTypeService{
	@Autowired
	 private CurrencyTypeRepository currencyTypeRepository;
	@Autowired
	private  CurrencyTypeBuilder currencyTypeBuilder;

	@Override
	public List<CurrencyTypeDto> getAll() {
		  List<CurrencyType>   currencies = currencyTypeRepository.findAll();
		  List<CurrencyTypeDto> currenciesDto =new ArrayList<>();
		  if(currencies!=null) {
			  System.out.println("we are in currency serviceImpl ");
			  System.out.println(currencies.size());
//			  currencies.forEach(curency -> {
//				  currenciesDto.add( currencyTypeBuilder.toDto(curency));
//			  });
			  for (CurrencyType currency:currencies) {
				  
				  CurrencyTypeDto currencyTypeDto =currencyTypeBuilder.toDto(currency);
						  currenciesDto.add(currencyTypeDto);
				
			} 
		  }
		
		
		return currenciesDto;
	}

}

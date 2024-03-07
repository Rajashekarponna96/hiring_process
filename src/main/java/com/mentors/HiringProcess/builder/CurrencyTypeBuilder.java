package com.mentors.HiringProcess.builder;

import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.dto.CurrencyTypeDto;
import com.mentors.HiringProcess.model.CurrencyType;
@Component
public class CurrencyTypeBuilder {
	
	public CurrencyType toModel(CurrencyTypeDto currencyTypeDto) {

		CurrencyType currencyType = new CurrencyType();
		currencyType.setId(currencyTypeDto.getId());
		currencyType.setName(currencyTypeDto.getName());
		currencyType.setCode(currencyTypeDto.getCode());
		currencyType.setSymbol(currencyTypeDto.getSymbol());
		return currencyType;
	}

	
	public CurrencyTypeDto toDto(CurrencyType currencyType) {
		CurrencyTypeDto currencyTypeDto = new CurrencyTypeDto();
		currencyTypeDto.setId(currencyType.getId());
		currencyTypeDto.setName(currencyType.getName());
		currencyTypeDto.setCode(currencyType.getCode());
		currencyTypeDto.setSymbol(currencyType.getSymbol());
		return currencyTypeDto;
}

}

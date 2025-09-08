package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.ParameterDto;
import com.domus.net.domain.dto.ResidenceDto;
import com.domus.net.domain.dto.TypeStateDto;
import com.domus.net.domain.enums.TypeState;
import com.domus.net.domain.service.ParameterService;
import com.domus.net.domain.service.ResidenceService;

import java.util.List;

@Application
public class ParameterApplication {

	private final ParameterService parameterService;

	public ParameterApplication(ParameterService parameterService) {
		this.parameterService = parameterService;
	}

	public ParameterDto findById(Long id){
		return parameterService.findById(id);
	}
	public boolean exist(Long id){
		return parameterService.exist(id);
	}
	public boolean existConcept(String concept){
		return parameterService.existConcept(concept);
	}

	public List<ParameterDto> getAll(){
		return parameterService.getAll();
	}

	public ParameterDto save(ParameterDto parameterDto){
		var state= TypeStateDto.builder().id(TypeState.ACTIVE.getValue()).build();
		parameterDto.setState(state);
		return parameterService.save(parameterDto);
	}

	public void delete(Long id){
		parameterService.delete(id);
	}
}

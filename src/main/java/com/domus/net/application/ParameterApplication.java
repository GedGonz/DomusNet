package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.ParameterDto;
import com.domus.net.domain.service.ParameterService;
import com.domus.net.infrastructure.enums.TypeStateEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


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

	public Page<ParameterDto> getAll(Pageable pageable){
		return parameterService.getAll(pageable);
	}

	public ParameterDto save(ParameterDto parameterDto){

		parameterDto.setState(TypeStateEnum.ACTIVE);
		return parameterService.save(parameterDto);
	}

	public void delete(Long id){
		parameterService.delete(id);
	}
}

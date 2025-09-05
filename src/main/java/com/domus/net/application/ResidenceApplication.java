package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.HomeDto;
import com.domus.net.domain.dto.ResidenceDto;
import com.domus.net.domain.service.HomeService;
import com.domus.net.domain.service.ResidenceService;

import java.util.List;

@Application
public class ResidenceApplication {

	private final ResidenceService residenceService;

	public ResidenceApplication(ResidenceService residenceService) {
		this.residenceService = residenceService;
	}

	public ResidenceDto findById(Long id){
		return residenceService.findById(id);
	}
	public boolean exist(Long id){
		return residenceService.exist(id);
	}
	public boolean existName(String name){
		return residenceService.existName(name);
	}

	public List<ResidenceDto> getAll(){
		return residenceService.getAll();
	}

	public ResidenceDto save(ResidenceDto residenceDto){
		return residenceService.save(residenceDto);
	}

	public void delete(Long id){
		residenceService.delete(id);
	}
}

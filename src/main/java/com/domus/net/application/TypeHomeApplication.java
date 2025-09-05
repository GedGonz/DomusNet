package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.ResidenceDto;
import com.domus.net.domain.dto.TypeHomeDto;
import com.domus.net.domain.service.ResidenceService;
import com.domus.net.domain.service.TypeHomeService;

import java.util.List;

@Application
public class TypeHomeApplication {

	private final TypeHomeService typeHomeService;

	public TypeHomeApplication(TypeHomeService typeHomeService) {
		this.typeHomeService = typeHomeService;
	}

	public TypeHomeDto findById(Long id){
		return typeHomeService.findById(id);
	}
	public boolean exist(Long id){
		return typeHomeService.exist(id);
	}
	public boolean existName(String name){
		return typeHomeService.existName(name);
	}

	public List<TypeHomeDto> getAll(){
		return typeHomeService.getAll();
	}

	public TypeHomeDto save(TypeHomeDto residenceDto){
		return typeHomeService.save(residenceDto);
	}

	public void delete(Long id){
		typeHomeService.delete(id);
	}
}

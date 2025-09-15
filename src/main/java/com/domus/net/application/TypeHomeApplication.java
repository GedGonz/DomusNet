package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.TypeHomeDto;
import com.domus.net.domain.service.TypeHomeService;
import com.domus.net.infrastructure.enums.TypeStateEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

	public Page<TypeHomeDto> getAll(Pageable pageable){
		return typeHomeService.getAll(pageable);
	}

	public TypeHomeDto save(TypeHomeDto residenceDto){

		residenceDto.setState(TypeStateEnum.ACTIVE);

		return typeHomeService.save(residenceDto);
	}

	public void delete(Long id){
		typeHomeService.delete(id);
	}
}

package com.domus.net.domain.service;

import com.domus.net.domain.dto.TypeHomeDto;
import com.domus.net.domain.mapper.TypeHomeMapper;
import com.domus.net.domain.repository.TypeHomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeHomeService {

	private final TypeHomeRepository typeHomeRepository;
	private final TypeHomeMapper typeHomeMapper;

	public TypeHomeService(TypeHomeRepository typeHomeRepository, TypeHomeMapper typeHomeMapper) {
		this.typeHomeRepository = typeHomeRepository;
		this.typeHomeMapper = typeHomeMapper;
	}

	public TypeHomeDto findById(Long id){
		return typeHomeMapper.typehomeToTypeHomeDto(typeHomeRepository.getFindById(id));
	}
	public boolean exist(Long id){
		return typeHomeRepository.exist(id);
	}
	public boolean existName(String name){
		return typeHomeRepository.existName(name);
	}

	public List<TypeHomeDto> getAll(){
		return typeHomeMapper.typehomesToTypeHomesDto(typeHomeRepository.getAll());
	}

	public TypeHomeDto save(TypeHomeDto residenceDto){
		var residence = typeHomeMapper.typehomeDtoToTypeHome(residenceDto);
		return typeHomeMapper.typehomeToTypeHomeDto(typeHomeRepository.save(residence));
	}

	public void delete(Long id){
		typeHomeRepository.delete(id);
	}

}

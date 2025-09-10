package com.domus.net.domain.service;

import com.domus.net.domain.dto.TypeHomeDto;
import com.domus.net.domain.mapper.TypeHomeMapper;
import com.domus.net.domain.repository.TypeHomeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

	public Page<TypeHomeDto> getAll(Pageable pageable){

		var typeHomesPage = typeHomeRepository.getAll(pageable);

		List<TypeHomeDto> typeHomeDtoList = typeHomeMapper.typehomesToTypeHomesDto(typeHomesPage.getContent());
		return new PageImpl<>(typeHomeDtoList, typeHomesPage.getPageable(), typeHomesPage.getTotalElements());
	}

	public TypeHomeDto save(TypeHomeDto residenceDto){
		var residence = typeHomeMapper.typehomeDtoToTypeHome(residenceDto);
		return typeHomeMapper.typehomeToTypeHomeDto(typeHomeRepository.save(residence));
	}

	public void delete(Long id){
		typeHomeRepository.delete(id);
	}

}

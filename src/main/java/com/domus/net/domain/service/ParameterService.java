package com.domus.net.domain.service;

import com.domus.net.domain.dto.ParameterDto;
import com.domus.net.domain.mapper.ParameterMapper;
import com.domus.net.domain.repository.ParameterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ParameterService {

	private final ParameterRepository parameterRepository;
	private final ParameterMapper parameterMapper;

	public ParameterService(ParameterRepository parameterRepository, ParameterMapper parameterMapper) {
		this.parameterRepository = parameterRepository;
		this.parameterMapper = parameterMapper;
	}


	public ParameterDto findById(Long id){
		return parameterMapper.parameterToParameterDto(parameterRepository.getFindById(id));
	}
	public boolean exist(Long id){
		return parameterRepository.exist(id);
	}
	public boolean existConcept(String concept){
		return parameterRepository.existConcept(concept);
	}

	public Page<ParameterDto> getAll(Pageable pageable){

		var parameterPage = parameterRepository.getAll(pageable);

		List<ParameterDto> residenceDtoList = parameterMapper.parameterToParameterDto(parameterPage.getContent());
		return new PageImpl<>(residenceDtoList, parameterPage.getPageable(), parameterPage.getTotalElements());
	}

	public ParameterDto save(ParameterDto parameterDto){
		var parameter = parameterMapper.parameterDtoToParameter(parameterDto);
		return parameterMapper.parameterToParameterDto(parameterRepository.save(parameter));
	}

	public void delete(Long id){
		parameterRepository.delete(id);
	}

}

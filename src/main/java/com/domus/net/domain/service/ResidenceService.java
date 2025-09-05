package com.domus.net.domain.service;

import com.domus.net.domain.dto.ResidenceDto;
import com.domus.net.domain.mapper.ResidenceMapper;
import com.domus.net.domain.repository.ResidenceRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ResidenceService {

	private final ResidenceRepository residenceRepository;
	private final ResidenceMapper residenceMapper;

	public ResidenceService(ResidenceRepository residenceRepository, ResidenceMapper residenceMapper) {
		this.residenceRepository = residenceRepository;
		this.residenceMapper = residenceMapper;
	}


	public ResidenceDto findById(Long id){
		return residenceMapper.residenceToResidenceDto(residenceRepository.getFindById(id));
	}
	public boolean exist(Long id){
		return residenceRepository.exist(id);
	}
	public boolean existName(String name){
		return residenceRepository.existName(name);
	}

	public List<ResidenceDto> getAll(){
		return residenceMapper.residenceToResidenceDto(residenceRepository.getAll());
	}

	public ResidenceDto save(ResidenceDto residenceDto){
		var residence = residenceMapper.residenceDtoToResidence(residenceDto);
		return residenceMapper.residenceToResidenceDto(residenceRepository.save(residence));
	}

	public void delete(Long id){
		residenceRepository.delete(id);
	}

}

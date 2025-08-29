package com.domus.net.domain.service;

import com.domus.net.domain.dto.HomeDto;
import com.domus.net.domain.mapper.HomeMapper;
import com.domus.net.domain.mapper.context.MappingContext;
import com.domus.net.domain.repository.HomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {


	private final HomeRepository homeRepository;
	private final HomeMapper homeMapper;
	private final MappingContext mappingContext;


	public HomeService(HomeRepository homeRepository, HomeMapper homeMapper, MappingContext mappingContext) {
		this.homeRepository = homeRepository;
		this.homeMapper = homeMapper;
		this.mappingContext = mappingContext;
	}

	public HomeDto findById(Long id){
		return homeMapper.homeToHomeDto(homeRepository.getFindById(id));
	}
	public boolean exist(Long id){
		return homeRepository.exist(id);
	}
	public boolean existNumber(String number){
		return homeRepository.existNumber(number);
	}

	public List<HomeDto> getAll(){
		return homeMapper.homessToHomesDto(homeRepository.getAll());
	}

	public HomeDto save(HomeDto homeDto){
		var home = homeMapper.homeDtoToHome(homeDto,mappingContext);
		return homeMapper.homeToHomeDto(homeRepository.save(home));
	}

	public void delete(Long id){
		homeRepository.delete(id);
	}

}

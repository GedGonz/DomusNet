package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.HomeDto;
import com.domus.net.domain.dto.TypeStateDto;
import com.domus.net.domain.enums.TypeState;
import com.domus.net.domain.service.HomeService;

import java.util.List;

@Application
public class HomeApplication {

	private final HomeService homeService;

	public HomeApplication(HomeService homeService) {
		this.homeService = homeService;
	}

	public HomeDto findById(Long id){
		return homeService.findById(id);
	}
	public boolean exist(Long id){
		return homeService.exist(id);
	}
	public boolean existNumber(String number){
		return homeService.existNumber(number);
	}

	public List<HomeDto> getAll(){
		return homeService.getAll();
	}

	public HomeDto save(HomeDto homeDto){

		var state= TypeStateDto.builder().id(TypeState.ACTIVE.getValue()).build();
		homeDto.setState(state);

		return homeService.save(homeDto);
	}


	public void delete(Long id){
		homeService.delete(id);
	}
}

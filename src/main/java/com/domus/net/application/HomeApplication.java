package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.HomeDto;
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

		if(homeDto.getTypeHome().getId()==null || homeDto.getTypeHome().getId()==0){
			throw new IllegalArgumentException("el campo typeHomeId es invalido");
		}
		if(homeDto.getResidence().getId()==null || homeDto.getResidence().getId()==0){
			throw new IllegalArgumentException("el campo residenceId es invalido");
		}
		if(homeDto.getState().getId()==null || homeDto.getState().getId()==0){
			throw new IllegalArgumentException("el campo residenceId es invalido");
		}

		return homeService.save(homeDto);
	}


	public void delete(Long id){
		homeService.delete(id);
	}
}

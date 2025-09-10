package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.HomeDto;
import com.domus.net.domain.dto.PersonDto;
import com.domus.net.domain.dto.TypeStateDto;
import com.domus.net.domain.enums.TypeState;
import com.domus.net.domain.service.HomeService;
import com.domus.net.domain.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;

@Application
public class HomeApplication {

	private final HomeService homeService;
	private final PersonService personService;

	public HomeApplication(HomeService homeService, PersonService personService) {
		this.homeService = homeService;
		this.personService = personService;
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

	public Page<HomeDto> getAll(Pageable pageable){
		return homeService.getAll(pageable);
	}

	public HomeDto save(HomeDto homeDto){

		var personsDto = new ArrayList<PersonDto>();
		var state= TypeStateDto.builder().id(TypeState.ACTIVE.getValue()).build();
		 homeDto.getPersons().forEach(personDto -> {
			 var personFounded= personService.findById(personDto.getId());
			if(personFounded!=null)
				personsDto.add(personFounded);
		});
		homeDto.setState(state);
		homeDto.getPersons().clear();
		homeDto.getPersons().addAll(personsDto);

		return homeService.save(homeDto);
	}


	public void delete(Long id){
		homeService.delete(id);
	}
}

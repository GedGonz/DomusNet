package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.PersonDto;
import com.domus.net.domain.service.PersonService;

import java.util.List;

@Application
public class PersonApplication {

	private final PersonService personService;

	public PersonApplication(PersonService personService) {
		this.personService = personService;
	}

	public PersonDto findById(Long id){
		return personService.findById(id);
	}
	public boolean exist(Long id){
		return personService.exist(id);
	}

	public List<PersonDto> getAll(){
		return personService.getAll();
	}

	public PersonDto save(PersonDto personDto){
		return personService.save(personDto);
	}

	public void delete(Long id){
		personService.delete(id);
	}
}

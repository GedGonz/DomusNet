package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.PersonDto;
import com.domus.net.domain.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

	public Page<PersonDto> getAll(Pageable pageable){
		return personService.getAll(pageable);
	}

	public PersonDto save(PersonDto personDto){
		return personService.save(personDto);
	}

	public void delete(Long id){
		personService.delete(id);
	}
}

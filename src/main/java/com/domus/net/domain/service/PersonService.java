package com.domus.net.domain.service;

import com.domus.net.domain.dto.PersonDto;
import com.domus.net.domain.mapper.PersonMapper;
import com.domus.net.domain.mapper.context.MappingContext;
import com.domus.net.domain.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {

	private final PersonRepository personRepository;
	private final PersonMapper personMapper;

	public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
		this.personRepository = personRepository;
		this.personMapper = personMapper;
	}

	public PersonDto findById(Long id){
		return personMapper.personToPersonDto(personRepository.getFindById(id));
	}
	public boolean exist(Long id){
		return personRepository.exist(id);
	}

	public List<PersonDto> getAll(){
		return personMapper.personToPersonDto(personRepository.getAll());
	}

	public PersonDto save(PersonDto personDto){
		var person = personMapper.personDtoToPerson(personDto);
		return personMapper.personToPersonDto(personRepository.save(person));
	}

	public void delete(Long id){
		personRepository.delete(id);
	}

}

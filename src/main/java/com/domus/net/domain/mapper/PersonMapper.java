package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.PersonDto;
import com.domus.net.infrastructure.entity.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {


	PersonDto personToPersonDto(Person person);

	Person personDtoToPerson(PersonDto personDto);

	List<Person> personDtoToPerson(List<PersonDto> personDtos);

	List<PersonDto> personToPersonDto(List<Person> persons);


}
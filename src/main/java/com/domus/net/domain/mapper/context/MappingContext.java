package com.domus.net.domain.mapper.context;

import com.domus.net.domain.repository.*;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class MappingContext {

	private final ResidenceRepository residenceRepository;
	private final TypeHomeRepository typeHomeRepository;
	private final PersonRepository personRepository;
	private final HomeRepository homeRepository;
	private final ParameterRepository parameterRepository;


	public MappingContext( ResidenceRepository residenceRepository, TypeHomeRepository typeHomeRepository, PersonRepository personRepository, HomeRepository homeRepository, ParameterRepository parameterRepository) {
		this.residenceRepository = residenceRepository;
		this.typeHomeRepository = typeHomeRepository;
		this.personRepository = personRepository;
		this.homeRepository = homeRepository;
		this.parameterRepository = parameterRepository;
	}
}


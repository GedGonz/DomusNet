package com.domus.net.domain.mapper.context;

import com.domus.net.domain.repository.ResidenceRepository;
import com.domus.net.domain.repository.TypeHomeRepository;
import com.domus.net.domain.repository.TypeStateRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class MappingContext {

	private final TypeStateRepository typeStateRepository;
	private final ResidenceRepository residenceRepository;
	private final TypeHomeRepository typeHomeRepository;


	public MappingContext(TypeStateRepository typeStateRepository, ResidenceRepository residenceRepository, TypeHomeRepository typeHomeRepository) {
		this.typeStateRepository = typeStateRepository;
		this.residenceRepository = residenceRepository;
		this.typeHomeRepository = typeHomeRepository;
	}
}


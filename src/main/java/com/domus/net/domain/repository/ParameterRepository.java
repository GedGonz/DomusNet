package com.domus.net.domain.repository;

import com.domus.net.domain.repository.base.baseRepository;
import com.domus.net.infrastructure.entity.Parameter;
import com.domus.net.infrastructure.enums.TypeStateEnum;

import java.util.List;

public interface ParameterRepository extends baseRepository<Parameter> {

	List<Parameter> findByState(TypeStateEnum state);
	boolean existConcept(String concept);
}

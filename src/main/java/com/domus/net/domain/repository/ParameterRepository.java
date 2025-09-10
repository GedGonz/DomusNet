package com.domus.net.domain.repository;

import com.domus.net.domain.repository.base.baseRepository;
import com.domus.net.infrastructure.entity.Parameter;

import java.util.List;

public interface ParameterRepository extends baseRepository<Parameter> {

	List<Parameter> findByState_Id(Long stateId);
	boolean existConcept(String concept);
}

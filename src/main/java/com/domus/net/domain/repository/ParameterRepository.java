package com.domus.net.domain.repository;

import com.domus.net.domain.repository.base.baseRepository;
import com.domus.net.infrastructure.entity.Parameter;

public interface ParameterRepository extends baseRepository<Parameter> {

	boolean existConcept(String concept);
}

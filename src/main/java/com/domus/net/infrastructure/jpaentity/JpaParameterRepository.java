package com.domus.net.infrastructure.jpaentity;

import com.domus.net.infrastructure.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaParameterRepository extends JpaRepository<Parameter,Long> {
	Optional<Boolean> existsByConceptIgnoreCase(String concept);
}

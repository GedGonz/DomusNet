package com.domus.net.infrastructure.jpaentity;

import com.domus.net.infrastructure.entity.Residence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaResidenceRepository extends JpaRepository<Residence,Long> {
	Optional<Boolean> existsByNameIgnoreCase(String name);
}

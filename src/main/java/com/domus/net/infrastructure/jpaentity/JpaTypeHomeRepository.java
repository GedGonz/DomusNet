package com.domus.net.infrastructure.jpaentity;

import com.domus.net.infrastructure.entity.TypeHome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaTypeHomeRepository extends JpaRepository<TypeHome,Long> {
	Optional<Boolean> existsByNameIgnoreCase(String name);
}

package com.domus.net.infrastructure.jpaentity;

import com.domus.net.infrastructure.entity.Residence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaResidenceRepository extends JpaRepository<Residence,Long> {
}

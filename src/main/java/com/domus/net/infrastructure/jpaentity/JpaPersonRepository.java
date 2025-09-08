package com.domus.net.infrastructure.jpaentity;

import com.domus.net.infrastructure.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPersonRepository extends JpaRepository<Person,Long> {
}

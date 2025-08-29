package com.domus.net.infrastructure.jpaentity;

import com.domus.net.infrastructure.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface JpaHomeCrudRepository extends JpaRepository<Home,Long> {

	Optional<Boolean> existsByNumber(String number);
}

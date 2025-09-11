package com.domus.net.infrastructure.jpaentity;

import com.domus.net.infrastructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<User,Long> {
	Optional<User> findByUsername(String username);
}

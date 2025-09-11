package com.domus.net.domain.repository;

import com.domus.net.domain.repository.base.baseRepository;
import com.domus.net.infrastructure.entity.User;

import java.util.Optional;


public interface UserRepository extends baseRepository<User> {

	Optional<User> findByUsername(String username);
}

package com.domus.net.infrastructure.adapter;

import com.domus.net.domain.repository.UserRepository;
import com.domus.net.infrastructure.entity.User;
import com.domus.net.infrastructure.jpaentity.JpaUserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Log4j2
@Repository
public class UserRepositoryImpl implements UserRepository {

	private final JpaUserRepository jpaUserRepository;

	public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
		this.jpaUserRepository = jpaUserRepository;
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return jpaUserRepository.findByUsername(username);
	}

	@Override
	public boolean exist(Long id) {
		return jpaUserRepository.findById(id).isPresent();
	}

	@Override
	public Page<User> getAll(Pageable pageable) {
		return jpaUserRepository.findAll(pageable);
	}

	@Override
	public User getFindById(Long id) {
		return jpaUserRepository.findById(id).orElse(null);
	}

	@Override
	public void saveAll(List<User> users) {
		jpaUserRepository.saveAll(users);
	}

	@Override
	public User save(User user) {
		return jpaUserRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		jpaUserRepository.findById(id).ifPresent(jpaUserRepository::delete);
	}
}

package com.domus.net.infrastructure.adapter;

import com.domus.net.domain.repository.HomeRepository;
import com.domus.net.infrastructure.entity.Home;
import com.domus.net.infrastructure.jpaentity.JpaHomeCrudRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Log4j2
@Repository
public class HomeRepositoryImpl implements HomeRepository {

	private final JpaHomeCrudRepository jpaHomeCrudRepository;

	public HomeRepositoryImpl(JpaHomeCrudRepository jpaHomeCrudRepository) {
		this.jpaHomeCrudRepository = jpaHomeCrudRepository;
	}


	@Override
	public boolean exist(Long id) {
		return jpaHomeCrudRepository.findById(id).isPresent();
	}

	@Override
	public boolean existNumber(String number) {
		return jpaHomeCrudRepository.existsByNumberIgnoreCase(number).orElse(false);
	}
	@Override
	public List<Home> getAll() {
		return jpaHomeCrudRepository.findAll();
	}

	@Override
	public Home getFindById(Long id) {
		return jpaHomeCrudRepository.findById(id).orElse(null);
	}

	@Override
	public void saveAll(List<Home> homes) {
		jpaHomeCrudRepository.saveAll(homes);
	}

	@Override
	public Home save(Home home) {
		return jpaHomeCrudRepository.save(home);
	}

	@Override
	public void delete(Long id) {
		jpaHomeCrudRepository.findById(id).ifPresent(jpaHomeCrudRepository::delete);
	}


}

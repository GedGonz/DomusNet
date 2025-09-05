package com.domus.net.infrastructure.adapter;

import com.domus.net.domain.repository.HomeRepository;
import com.domus.net.domain.repository.ResidenceRepository;
import com.domus.net.infrastructure.entity.Home;
import com.domus.net.infrastructure.entity.Residence;
import com.domus.net.infrastructure.jpaentity.JpaHomeCrudRepository;
import com.domus.net.infrastructure.jpaentity.JpaResidenceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
@Repository
public class ResidenceRepositoryImpl implements ResidenceRepository {

	private final JpaResidenceRepository jpaResidenceRepository;

	public ResidenceRepositoryImpl(JpaResidenceRepository jpaResidenceRepository) {
		this.jpaResidenceRepository = jpaResidenceRepository;
	}


	@Override
	public boolean exist(Long id) {
		return jpaResidenceRepository.findById(id).isPresent();
	}

	@Override
	public List<Residence> getAll() {
		return jpaResidenceRepository.findAll();
	}

	@Override
	public Residence getFindById(Long id) {
		return jpaResidenceRepository.findById(id).orElse(null);
	}

	@Override
	public void saveAll(List<Residence> residences) {
		jpaResidenceRepository.saveAll(residences);
	}

	@Override
	public Residence save(Residence residence) {
		return jpaResidenceRepository.save(residence);
	}

	@Override
	public void delete(Long id) {
		jpaResidenceRepository.findById(id).ifPresent(jpaResidenceRepository::delete);
	}

	@Override
	public boolean existName(String name) {
		return jpaResidenceRepository.existsByNameIgnoreCase(name).orElse(false);
	}
}

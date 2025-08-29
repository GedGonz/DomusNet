package com.domus.net.infrastructure.adapter;

import com.domus.net.domain.repository.TypeHomeRepository;
import com.domus.net.infrastructure.entity.TypeHome;
import com.domus.net.infrastructure.jpaentity.JpaTypeHomeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
@Repository
public class TypeHomeRepositoryImpl implements TypeHomeRepository {

	private final JpaTypeHomeRepository jpaTypeHomeRepository;

	public TypeHomeRepositoryImpl(JpaTypeHomeRepository jpaTypeHomeRepository) {
		this.jpaTypeHomeRepository = jpaTypeHomeRepository;
	}

	@Override
	public boolean exist(Long id) {
		return jpaTypeHomeRepository.findById(id).isPresent();
	}


	@Override
	public List<TypeHome> getAll() {
		return jpaTypeHomeRepository.findAll();
	}

	@Override
	public TypeHome getFindById(Long id) {
		return jpaTypeHomeRepository.findById(id).orElse(null);
	}

	@Override
	public void saveAll(List<TypeHome> typeHomes) {
		jpaTypeHomeRepository.saveAll(typeHomes);
	}

	@Override
	public TypeHome save(TypeHome typeHome) {
		return jpaTypeHomeRepository.save(typeHome);
	}

	@Override
	public void delete(Long id) {
		jpaTypeHomeRepository.findById(id).ifPresent(jpaTypeHomeRepository::delete);
	}
}

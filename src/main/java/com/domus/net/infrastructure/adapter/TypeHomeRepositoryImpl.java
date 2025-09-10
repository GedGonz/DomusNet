package com.domus.net.infrastructure.adapter;

import com.domus.net.domain.repository.TypeHomeRepository;
import com.domus.net.infrastructure.entity.TypeHome;
import com.domus.net.infrastructure.jpaentity.JpaTypeHomeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<TypeHome> getAll(Pageable pageable) {
		return jpaTypeHomeRepository.findAll(pageable);
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

	@Override
	public boolean existName(String name) {
		return jpaTypeHomeRepository.existsByNameIgnoreCase(name).orElse(false);
	}
}

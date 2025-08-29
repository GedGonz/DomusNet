package com.domus.net.infrastructure.adapter;

import com.domus.net.domain.repository.TypeStateRepository;
import com.domus.net.infrastructure.entity.TypeState;
import com.domus.net.infrastructure.jpaentity.JpaTypStateRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
@Repository
public class TypeStateRepositoryImpl implements TypeStateRepository {

	private final JpaTypStateRepository jpaTypStateRepository;

	public TypeStateRepositoryImpl(JpaTypStateRepository jpaTypStateRepository) {
		this.jpaTypStateRepository = jpaTypStateRepository;
	}


	@Override
	public boolean exist(Long id) {
		return jpaTypStateRepository.findById(id).isPresent();
	}

	@Override
	public List<TypeState> getAll() {
		return jpaTypStateRepository.findAll();
	}

	@Override
	public TypeState getFindById(Long id) {
		return jpaTypStateRepository.findById(id).orElse(null);
	}

	@Override
	public void saveAll(List<TypeState> typeHomes) {
		jpaTypStateRepository.saveAll(typeHomes);
	}

	@Override
	public TypeState save(TypeState typeHome) {
		return jpaTypStateRepository.save(typeHome);
	}

	@Override
	public void delete(Long id) {
		jpaTypStateRepository.findById(id).ifPresent(jpaTypStateRepository::delete);
	}
}

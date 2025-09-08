package com.domus.net.infrastructure.adapter;

import com.domus.net.domain.repository.ParameterRepository;
import com.domus.net.infrastructure.entity.Parameter;
import com.domus.net.infrastructure.jpaentity.JpaParameterRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
@Repository
public class ParameterRepositoryImpl implements ParameterRepository {

	private final JpaParameterRepository jpaParameterRepository;

	public ParameterRepositoryImpl(JpaParameterRepository jpaParameterRepository) {
		this.jpaParameterRepository = jpaParameterRepository;
	}

	@Override
	public boolean exist(Long id) {
		return jpaParameterRepository.findById(id).isPresent();
	}

	@Override
	public List<Parameter> getAll() {
		return jpaParameterRepository.findAll();
	}

	@Override
	public Parameter getFindById(Long id) {
		return jpaParameterRepository.findById(id).orElse(null);
	}

	@Override
	public void saveAll(List<Parameter> parameters) {
		jpaParameterRepository.saveAll(parameters);
	}

	@Override
	public Parameter save(Parameter parameter) {
		return jpaParameterRepository.save(parameter);
	}

	@Override
	public void delete(Long id) {
		jpaParameterRepository.findById(id).ifPresent(jpaParameterRepository::delete);
	}

	@Override
	public boolean existConcept(String concept) {
		return jpaParameterRepository.existsByConceptIgnoreCase(concept).orElse(false);
	}
}

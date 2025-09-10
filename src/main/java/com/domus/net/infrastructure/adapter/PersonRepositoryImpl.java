package com.domus.net.infrastructure.adapter;

import com.domus.net.domain.repository.PersonRepository;
import com.domus.net.infrastructure.entity.Person;
import com.domus.net.infrastructure.jpaentity.JpaPersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
@Repository
public class PersonRepositoryImpl implements PersonRepository {

	private final JpaPersonRepository jpaPersonRepository;

	public PersonRepositoryImpl(JpaPersonRepository jpaPersonRepository) {
		this.jpaPersonRepository = jpaPersonRepository;
	}

	@Override
	public boolean exist(Long id) {
		return jpaPersonRepository.findById(id).isPresent();
	}

	@Override
	public Page<Person> getAll(Pageable pageable) {
		return jpaPersonRepository.findAll(pageable);
	}

	@Override
	public Person getFindById(Long id) {
		return jpaPersonRepository.findById(id).orElse(null);
	}

	@Override
	public void saveAll(List<Person> persons) {
		jpaPersonRepository.saveAll(persons);
	}

	@Override
	public Person save(Person person) {
		return jpaPersonRepository.save(person);
	}

	@Override
	public void delete(Long id) {
		jpaPersonRepository.findById(id).ifPresent(jpaPersonRepository::delete);
	}

}

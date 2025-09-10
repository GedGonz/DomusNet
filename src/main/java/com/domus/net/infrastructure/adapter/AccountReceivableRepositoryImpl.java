package com.domus.net.infrastructure.adapter;

import com.domus.net.domain.repository.AccountReceivableRepository;
import com.domus.net.infrastructure.entity.AccountsReceivable;
import com.domus.net.infrastructure.jpaentity.JpaAccountReceivableCrudRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@Repository
public class AccountReceivableRepositoryImpl implements AccountReceivableRepository {

	private final JpaAccountReceivableCrudRepository jpaAccountReceivableCrudRepository;

	public AccountReceivableRepositoryImpl(JpaAccountReceivableCrudRepository jpaAccountReceivableCrudRepository) {
		this.jpaAccountReceivableCrudRepository = jpaAccountReceivableCrudRepository;
	}

	@Override
	public boolean exist(Long id) {
		return jpaAccountReceivableCrudRepository.findById(id).isPresent();
	}

	@Override
	public Page<AccountsReceivable> getAll(Pageable pageable) {
		return jpaAccountReceivableCrudRepository.findAll(pageable);
	}

	@Override
	public AccountsReceivable getFindById(Long id) {
		return jpaAccountReceivableCrudRepository.findById(id).orElse(null);
	}

	@Override
	public void saveAll(List<AccountsReceivable> homes) {
		jpaAccountReceivableCrudRepository.saveAll(homes);
	}

	@Override
	public AccountsReceivable save(AccountsReceivable accountsReceivable) {
		return jpaAccountReceivableCrudRepository.save(accountsReceivable);
	}

	@Override
	public void delete(Long id) {
		jpaAccountReceivableCrudRepository.findById(id).ifPresent(jpaAccountReceivableCrudRepository::delete);
	}

	@Override
	public void generateMontlydebet(LocalDate date) {
		jpaAccountReceivableCrudRepository.generateMonthlyDebt(date);
	}
}

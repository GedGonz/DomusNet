package com.domus.net.domain.service;

import com.domus.net.domain.dto.AccountsReceivableDto;
import com.domus.net.domain.mapper.AccountReceivableMapper;
import com.domus.net.domain.repository.AccountReceivableRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountReceivableService {


	private final AccountReceivableRepository accountReceivableRepository;
	private final AccountReceivableMapper accountReceivableMapper;

	public AccountReceivableService(AccountReceivableRepository accountReceivableRepository, AccountReceivableMapper accountReceivableMapper) {
		this.accountReceivableRepository = accountReceivableRepository;
		this.accountReceivableMapper = accountReceivableMapper;
	}

	public boolean exist(Long id){
		return accountReceivableRepository.exist(id);
	}

	public List<AccountsReceivableDto> getAll(){
		return accountReceivableMapper.accountsReceivableToAccountsReceivableDto(accountReceivableRepository.getAll());
	}

	public void delete(Long id){
		accountReceivableRepository.delete(id);
	}

	@Transactional
	public void generateMontlydebet(LocalDate date){
		 accountReceivableRepository.generateMontlydebet(date);
	}

}

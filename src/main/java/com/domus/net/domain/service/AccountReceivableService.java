package com.domus.net.domain.service;

import com.domus.net.domain.dto.AccountsReceivableDto;
import com.domus.net.domain.mapper.AccountReceivableMapper;
import com.domus.net.domain.repository.AccountReceivableRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

	public Page<AccountsReceivableDto> getAll(Pageable pageable){

		var homesPage = accountReceivableRepository.getAll(pageable);

		List<AccountsReceivableDto> accountsReceivableDtoDtoList = accountReceivableMapper.accountsReceivableToAccountsReceivableDto(homesPage.getContent());
		return new PageImpl<>(accountsReceivableDtoDtoList, homesPage.getPageable(), homesPage.getTotalElements());

	}

	public void delete(Long id){
		accountReceivableRepository.delete(id);
	}

	@Transactional
	public void generateMontlydebet(LocalDate date){
		 accountReceivableRepository.generateMontlydebet(date);
	}

}

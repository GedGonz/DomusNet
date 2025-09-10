package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.AccountsReceivableDto;
import com.domus.net.domain.service.AccountReceivableService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Application
public class AccountReceivableApplication {

	private final AccountReceivableService accountReceivableService;

	public AccountReceivableApplication(AccountReceivableService accountReceivableService) {
		this.accountReceivableService = accountReceivableService;
	}

	public boolean exist(Long id){
		return accountReceivableService.exist(id);
	}

	public Page<AccountsReceivableDto> getAll(Pageable pageable){
		return accountReceivableService.getAll(pageable);
	}

	public void delete(Long id){
		accountReceivableService.delete(id);
	}
}


package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.AccountsReceivableDto;
import com.domus.net.domain.service.AccountReceivableService;

import java.util.List;

@Application
public class AccountReceivableApplication {

	private final AccountReceivableService accountReceivableService;

	public AccountReceivableApplication(AccountReceivableService accountReceivableService) {
		this.accountReceivableService = accountReceivableService;
	}

	public boolean exist(Long id){
		return accountReceivableService.exist(id);
	}

	public List<AccountsReceivableDto> getAll(){
		return accountReceivableService.getAll();
	}

	public void delete(Long id){
		accountReceivableService.delete(id);
	}
}


package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.AccountsReceivableDto;
import com.domus.net.infrastructure.entity.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {HomeMapper.class, ParameterMapper.class })
public interface AccountReceivableMapper {


	AccountsReceivableDto accountsReceivableToAccountsReceivableDto(AccountsReceivable accountsReceivable);

	AccountsReceivable accountsReceivableDtoToAccountsReceivable(AccountsReceivableDto personDto);

	List<AccountsReceivable> accountsReceivableDtoToAccountsReceivable(List<AccountsReceivableDto> accountsReceivableDtos);

	List<AccountsReceivableDto> accountsReceivableToAccountsReceivableDto(List<AccountsReceivable> accountsReceivables);

}
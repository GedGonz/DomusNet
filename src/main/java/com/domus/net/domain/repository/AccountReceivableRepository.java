package com.domus.net.domain.repository;

import com.domus.net.domain.repository.base.baseRepository;
import com.domus.net.infrastructure.entity.AccountsReceivable;
import java.time.LocalDate;


public interface AccountReceivableRepository extends baseRepository<AccountsReceivable> {
	void generateMontlydebet(LocalDate date);
}

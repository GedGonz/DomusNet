package com.domus.net.domain.repository;

import com.domus.net.domain.repository.base.baseRepository;
import com.domus.net.infrastructure.entity.Voucher;
import org.springframework.data.repository.query.Param;


public interface VoucherRepository extends baseRepository<Voucher> {

	void processVoucher(@Param("voucherId") Long voucherId);
}

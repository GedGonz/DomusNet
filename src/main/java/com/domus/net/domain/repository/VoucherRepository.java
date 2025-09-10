package com.domus.net.domain.repository;

import com.domus.net.domain.repository.base.baseRepository;
import com.domus.net.infrastructure.entity.TypeVoucher;
import com.domus.net.infrastructure.entity.Voucher;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VoucherRepository extends baseRepository<Voucher> {

	List<Voucher> getAllByTypeVoucher(TypeVoucher typeVoucher);
	boolean existNumReference(String numRef);
	void processVoucher(@Param("voucherId") Long voucherId);
	String revertAccountsReceivable(Integer voucherId);
}

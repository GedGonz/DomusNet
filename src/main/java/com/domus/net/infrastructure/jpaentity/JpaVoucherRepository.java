package com.domus.net.infrastructure.jpaentity;

import com.domus.net.infrastructure.entity.TypeVoucher;
import com.domus.net.infrastructure.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface JpaVoucherRepository extends JpaRepository<Voucher,Long> {

	List<Voucher> findByTypeVoucher(TypeVoucher typeVoucher);

	@Query(value = "SELECT process_voucher(:voucherId)", nativeQuery = true)
	void processVoucher(@Param("voucherId") Integer voucherId);

	@Query(value = "SELECT revert_accounts_receivable(:voucherId)", nativeQuery = true)
	String revertAccountsReceivable(@Param("voucherId") Integer voucherId);

	Optional<Boolean> existsByNumReferenceIgnoreCase(String numRef);
}

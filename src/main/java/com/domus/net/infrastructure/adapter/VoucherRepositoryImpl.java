package com.domus.net.infrastructure.adapter;

import com.domus.net.domain.repository.VoucherRepository;
import com.domus.net.infrastructure.entity.TypeVoucher;
import com.domus.net.infrastructure.entity.Voucher;
import com.domus.net.infrastructure.jpaentity.JpaVoucherRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Log4j2
@Repository
public class VoucherRepositoryImpl implements VoucherRepository {

	private final JpaVoucherRepository jpaVoucherRepository;

	public VoucherRepositoryImpl(JpaVoucherRepository jpaVoucherRepository) {
		this.jpaVoucherRepository = jpaVoucherRepository;
	}

	@Override
	public boolean exist(Long id) {
		return jpaVoucherRepository.findById(id).isPresent();
	}

	@Override
	public List<Voucher> getAllByTypeVoucher(TypeVoucher typeVoucher) {
		return jpaVoucherRepository.findByTypeVoucher(typeVoucher);
	}

	@Override
	public boolean existNumReference(String numRef) {
		return jpaVoucherRepository.existsByNumReference(numRef);
	}

	@Override
	public Page<Voucher> getAll(Pageable pageable) {
		return jpaVoucherRepository.findAll(pageable);
	}

	@Override
	public Voucher getFindById(Long id) {
		return jpaVoucherRepository.findById(id).orElse(null);
	}

	@Override
	public void saveAll(List<Voucher> vouchers) {
		jpaVoucherRepository.saveAll(vouchers);
	}

	@Override
	public Voucher save(Voucher voucher) {
		return jpaVoucherRepository.save(voucher);
	}

	@Override
	public void delete(Long id) {
		jpaVoucherRepository.findById(id).ifPresent(jpaVoucherRepository::delete);
	}

	@Override
	public void processVoucher(Long voucherId) {
		jpaVoucherRepository.processVoucher(Integer.parseInt(voucherId.toString()));
	}

	@Override
	public String revertAccountsReceivable(Long voucherId) {
		return jpaVoucherRepository.revertAccountsReceivable(Integer.parseInt(voucherId.toString()) );
	}
}

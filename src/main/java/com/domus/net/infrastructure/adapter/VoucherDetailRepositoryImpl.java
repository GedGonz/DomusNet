package com.domus.net.infrastructure.adapter;

import com.domus.net.domain.repository.VoucherDetailRepository;
import com.domus.net.infrastructure.entity.VoucherDetail;
import com.domus.net.infrastructure.jpaentity.JpaVoucherDetailRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
@Repository
public class VoucherDetailRepositoryImpl implements VoucherDetailRepository {

	private final JpaVoucherDetailRepository voucherDetailRepository;

	public VoucherDetailRepositoryImpl(JpaVoucherDetailRepository voucherDetailRepository) {
		this.voucherDetailRepository = voucherDetailRepository;
	}


	@Override
	public boolean exist(Long id) {
		return voucherDetailRepository.findById(id).isPresent();
	}

	@Override
	public Page<VoucherDetail> getAll(Pageable pageable) {
		return voucherDetailRepository.findAll(pageable);
	}

	@Override
	public VoucherDetail getFindById(Long id) {
		return voucherDetailRepository.findById(id).orElse(null);
	}

	@Override
	public void saveAll(List<VoucherDetail> voucherDetails) {
		voucherDetailRepository.saveAll(voucherDetails);
	}

	@Override
	public VoucherDetail save(VoucherDetail voucherDetail) {
		return voucherDetailRepository.save(voucherDetail);
	}

	@Override
	public void delete(Long id) {
		voucherDetailRepository.findById(id).ifPresent(voucherDetailRepository::delete);
	}

}

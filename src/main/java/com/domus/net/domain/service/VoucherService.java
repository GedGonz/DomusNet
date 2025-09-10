package com.domus.net.domain.service;

import com.domus.net.domain.dto.ParameterDto;
import com.domus.net.domain.dto.VoucherDetailDto;
import com.domus.net.domain.dto.VoucherDto;
import com.domus.net.domain.enums.TypeState;
import com.domus.net.domain.mapper.VoucherDetailMapper;
import com.domus.net.domain.mapper.VoucherMapper;
import com.domus.net.domain.repository.ParameterRepository;
import com.domus.net.domain.repository.VoucherDetailRepository;
import com.domus.net.domain.repository.VoucherRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class VoucherService {

	private final VoucherRepository voucherRepository;
	private final VoucherDetailRepository voucherDetailRepository;
	private final ParameterRepository parameterRepository;
	private final VoucherMapper voucherMapper;
	private final VoucherDetailMapper voucherDetailMapper;

	public VoucherService(VoucherRepository voucherRepository, VoucherDetailRepository voucherDetailRepository, ParameterRepository parameterRepository, VoucherMapper voucherMapper, VoucherDetailMapper voucherDetailMapper) {
		this.voucherRepository = voucherRepository;
		this.voucherDetailRepository = voucherDetailRepository;
		this.parameterRepository = parameterRepository;
		this.voucherMapper = voucherMapper;
		this.voucherDetailMapper = voucherDetailMapper;
	}

	public VoucherDto findById(Long id){
		return voucherMapper.voucherToVoucherDto(voucherRepository.getFindById(id));
	}
	public boolean existNumReference(String numRef){
		return voucherRepository.existNumReference(numRef);
	}

	public boolean exist(Long id){
		return voucherRepository.exist(id);
	}

	public Page<VoucherDto> getAll(Pageable pageable){

		var vouchersPage = voucherRepository.getAll(pageable);

		List<VoucherDto> voucherDtoList = voucherMapper.voucherToVoucherDto(vouchersPage.getContent());
		return new PageImpl<>(voucherDtoList, vouchersPage.getPageable(), vouchersPage.getTotalElements());
	}

	@Transactional
	public VoucherDto save(VoucherDto voucherDto){

		var parameters = parameterRepository.findByState_Id(TypeState.ACTIVE.getValue());

		var voucher = voucherMapper.voucherDtoToVoucher(voucherDto);
		var voucherSaved = voucherMapper.voucherToVoucherDto(voucherRepository.save(voucher));

		final BigDecimal[] totalPaid = {voucherSaved.getAmount()};
		voucherDto.setId(voucherSaved.getId());
		parameters.forEach(parameter -> {

			if(isAmountSufficient(totalPaid[0],parameter.getAmount())) {
				var voucherDetail = VoucherDetailDto.builder()
						.concept(parameter.getConcept())
						.amount(parameter.getAmount())
						.voucher(voucherDto)
						.parameter(ParameterDto.builder().id(parameter.getId()).build())
						.build();

				var voucherEntity = voucherDetailMapper.voucherDetailDtoToVoucherDetail(voucherDetail);
				voucherDetailRepository.save(voucherEntity);
				totalPaid[0] = totalPaid[0].subtract(parameter.getAmount());
			}

		});

		voucherRepository.processVoucher(voucherSaved.getId());
		return voucherSaved;
	}

	public void delete(Long id){
		voucherRepository.delete(id);
	}
	
	private boolean isAmountSufficient(BigDecimal totalPaid, BigDecimal amountParameter){
	    return totalPaid.compareTo(amountParameter) >= 0;
	}

	public String revertAccountsReceivable(Long voucherId) {
		return voucherRepository.revertAccountsReceivable(voucherId);
	}

}

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
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


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
	public boolean exist(Long id){
		return voucherRepository.exist(id);
	}

	public List<VoucherDto> getAll(){
		var result=voucherRepository.getAll();
		return voucherMapper.voucherToVoucherDto(result);
	}

	@Transactional
	public VoucherDto save(VoucherDto voucherDto){

		var parameters = parameterRepository.getAll().stream().filter(x-> Objects.equals(x.getState().getId(), TypeState.ACTIVE.getValue()));

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

}

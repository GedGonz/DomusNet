package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.VoucherDto;
import com.domus.net.infrastructure.entity.Voucher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, HomeMapper.class, VoucherDetailMapper.class})
public interface VoucherMapper {

	VoucherDto voucherToVoucherDto(Voucher voucher);

	Voucher voucherDtoToVoucher(VoucherDto voucherDto);

	List<Voucher> voucherDtoToVoucher(List<VoucherDto> voucherDtos);
	List<VoucherDto> voucherToVoucherDto(List<Voucher> vouchers);

}
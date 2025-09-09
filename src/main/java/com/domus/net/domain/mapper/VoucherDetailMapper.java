package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.VoucherDetailDto;
import com.domus.net.infrastructure.entity.VoucherDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoucherDetailMapper {

	@Mapping(target = "voucher", ignore = true)
	VoucherDetailDto voucherDetailToVoucherDetailDto(VoucherDetail voucherDetail);

	VoucherDetail voucherDetailDtoToVoucherDetail(VoucherDetailDto voucherDetailDto);
	List<VoucherDetail> voucherDetailDtoToVoucherDetail(List<VoucherDetailDto> voucherDetailDtos);
	List<VoucherDetailDto> voucherDetailToVoucherDetailDto(List<VoucherDetail> voucherDetails);

}
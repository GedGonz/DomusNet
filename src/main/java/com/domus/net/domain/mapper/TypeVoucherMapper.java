package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.TypeVoucherDto;
import com.domus.net.infrastructure.entity.TypeVoucher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeVoucherMapper {

	TypeVoucherDto typeVoucherToTypeVoucherDto(TypeVoucher typeVoucher);

	TypeVoucher typeVoucherDtoToTypeVoucher(TypeVoucherDto typeVoucherDto);

	List<TypeVoucher> typeVoucherDtoToTypeVoucher(List<TypeVoucherDto> typeVoucherDtos);
	List<TypeVoucherDto> typeVoucherToTypeVoucherDto(List<TypeVoucher> typeVouchers);

}
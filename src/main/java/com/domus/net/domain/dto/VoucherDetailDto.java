package com.domus.net.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoucherDetailDto {

	private Long id;

	private String concept;

	private BigDecimal amount;

	private VoucherDto voucher;

	private ParameterDto parameter;
}

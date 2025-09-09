package com.domus.net.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountsReceivableDto {

	private Integer id;

	private String concept;

	private BigDecimal totalAmount;

	private BigDecimal paidAmount;

	private LocalDate dueDate;

	private HomeDto home;

	private ParameterDto parameter;

	//private TypeStateAccountsReceivable state;
}

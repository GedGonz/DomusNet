package com.domus.net.domain.dto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class TypeHomeDto {

	public Long id;
	private String name;
	private String description;
	private BigDecimal discount;
	private TypeStateDto state;
}

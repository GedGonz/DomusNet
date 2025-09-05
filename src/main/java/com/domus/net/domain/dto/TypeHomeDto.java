package com.domus.net.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeHomeDto {

	public Long id;
	private String name;
	private String description;
	private BigDecimal discount;
	private TypeStateDto state;
}

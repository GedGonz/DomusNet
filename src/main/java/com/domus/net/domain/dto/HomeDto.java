package com.domus.net.domain.dto;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class HomeDto {

	public Long id;
	private String number;
	private String model;
	private TypeStateDto state;
	private ResidenceDto residence;
	private TypeHomeDto typeHome;
}

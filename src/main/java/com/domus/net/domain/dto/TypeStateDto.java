package com.domus.net.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeStateDto {


	public Long id;
	private String name;
	private String description;

}
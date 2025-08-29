package com.domus.net.domain.dto;


import lombok.Builder;
import lombok.Data;


import java.time.LocalDate;
import java.util.Set;
@Data
@Builder
public class ResidenceDto {

	public Long id;
	private String name;
	private String location;
	private Integer telephone;
	private LocalDate fundingDate;
}

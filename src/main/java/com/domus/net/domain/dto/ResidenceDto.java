package com.domus.net.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResidenceDto {

	public Long id;
	private String name;
	private String location;
	private Integer telephone;
	private LocalDate fundingDate;
}

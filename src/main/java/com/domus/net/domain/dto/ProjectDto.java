package com.domus.net.domain.dto;


import com.domus.net.infrastructure.enums.TypeStateEnum;

import java.time.LocalDate;

public class ProjectDto {

	public Long id;
	private String name;
	private String description;
	private LocalDate dateInit;
	private LocalDate dateEnd;
	private ResidenceDto residence;
	private TypeStateEnum state;
}

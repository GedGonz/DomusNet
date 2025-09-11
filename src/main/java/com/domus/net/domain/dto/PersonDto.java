package com.domus.net.domain.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

	public Long id;

	@NotNull(message = "El nombre no puede ser nulo")
	@Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
	private String name;

	@NotNull(message = "El apellido no puede ser nulo")
	@Size(min = 1, max = 50, message = "El apellido debe tener entre 1 y 50 caracteres")
	private String lastname;

	@NotNull(message = "El telefono 1 no puede ser nulo")
	private Integer phone1;

	@NotNull(message = "El email 1 no puede ser nulo")
	private String email1;

	@NotNull(message = "El telefono 2 no puede ser nulo")
	private Integer phone2;

	@NotNull(message = "El email 2 no puede ser nulo")
	private String email2;
}
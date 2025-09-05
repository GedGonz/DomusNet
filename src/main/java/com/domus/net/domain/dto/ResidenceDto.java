package com.domus.net.domain.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResidenceDto {

	public Long id;
	@NotNull(message = "El nombre no puede ser nulo")
	@Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
	private String name;
	@NotNull(message = "La locación no puede ser nulo")
	@Size(min = 1, max = 100, message = "La locación debe tener entre 1 y 100 caracteres")
	private String location;
	@NotNull(message = "El telefono no puede ser nulo")
	private Integer telephone;
	@NotNull(message = "La fecha de fundación no puede ser nulo")
	private LocalDate fundingDate;
}

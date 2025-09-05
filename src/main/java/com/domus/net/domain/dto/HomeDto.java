package com.domus.net.domain.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeDto {

	public Long id;
	@NotNull(message = "El número de casa no puede ser nulo")
	@Size(min = 1, max = 10, message = "El número debe tener entre 1 y 10 caracteres")
	private String number;
	@NotNull(message = "El modelo de casa no puede ser nulo")
	@Size(min = 1, max = 50, message = "El modelo debe tener entre 1 y 50 caracteres")
	private String model;
	@NotNull(message = "El estado de casa no puede ser nulo")
	private TypeStateDto state;
	@NotNull(message = "La redisencia de casa no puede ser nulo")
	private ResidenceDto residence;
	@NotNull(message = "El tipo de casa no puede ser nulo")
	private TypeHomeDto typeHome;
}

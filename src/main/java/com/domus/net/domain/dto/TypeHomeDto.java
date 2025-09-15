package com.domus.net.domain.dto;

import com.domus.net.infrastructure.enums.TypeStateEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeHomeDto {

	public Long id;
	@NotNull(message = "El nombre no puede ser nulo")
	@Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
	private String name;
	@NotNull(message = "La descripción no puede ser nulo")
	@Size(min = 1, max = 50, message = "La descripción debe tener entre 1 y 50 caracteres")
	private String description;
	@NotNull(message = "El descuento no puede ser nulo")
	private BigDecimal discount;

	private TypeStateEnum state;
}

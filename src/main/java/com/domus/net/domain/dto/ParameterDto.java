package com.domus.net.domain.dto;

import com.domus.net.infrastructure.enums.TypeStateEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParameterDto {

	public Long id;

	@NotNull(message = "El concepto no puede ser nulo")
	@Size(min = 1, max = 100, message = "El concepto debe tener entre 1 y 100 caracteres")
	private String concept;

	@NotNull(message = "El monto no puede ser nulo")
	private BigDecimal amount;

	@NotNull(message = "La fecha de registro no puede ser nulo")
	private LocalDate dateRecord;

	private TypeStateEnum state;
}
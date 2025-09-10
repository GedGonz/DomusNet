package com.domus.net.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoucherDto {

	private Long id;

	@NotNull(message = "El concepto no puede ser nulo")
	@Size(min = 1, max = 100, message = "El concepto debe tener entre 1 y 100 caracteres")
	private String concept;

	@NotNull(message = "El monto no puede ser nulo")
	private BigDecimal amount;

	@NotNull(message = "El numero de referencia no puede ser nulo")
	private String numReference;

	private MultipartFile resourceFile;

	private String photo;

	@NotNull(message = "La fecha de registro no puede ser nulo")
	private LocalDate dateRecord;

	@NotNull(message = "El período de inicio no puede ser nulo")
	private LocalDate periodInit;

	@NotNull(message = "El período de fin no puede ser nulo")
	private LocalDate periodEnd;

	private UserDto user;
	@NotNull(message = "La cada no puede ser nulo")
	private HomeDto home;

	@NotNull(message = "El tipo de voucher no puede ser nulo")
	private TypeVoucherDto typeVoucher;

	private Set<VoucherDetailDto> details;
}

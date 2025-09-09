package com.domus.net.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeVoucherDto {

	public Long id;

	private String name;

	private String description;

	private LocalDate dateRecord;
}

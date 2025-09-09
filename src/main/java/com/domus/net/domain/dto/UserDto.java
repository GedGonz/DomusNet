package com.domus.net.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	public Long id;

	private String username;

	private String password;

	private LocalDate dateRecord;

	private TypeStateDto state;

	private PersonDto person;

	private RoleDto role;
}

package com.domus.net.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	public Long id;

	private String username;
	private String password;
	private TypeStateDto state;
	private PersonDto person;

	private boolean enabled;
	private boolean accountNoExpired;
	private boolean accountNoLocked;
	private boolean credentialNoExpired;

	private Set<RoleDto> roles;
}

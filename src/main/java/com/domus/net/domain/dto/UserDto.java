package com.domus.net.domain.dto;

import com.domus.net.infrastructure.enums.TypeStateEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@JsonIgnore
	private String password;
	private TypeStateEnum state;
	private PersonDto person;

	private boolean enabled;
	@JsonIgnore
	private boolean accountNoExpired;
	@JsonIgnore
	private boolean accountNoLocked;
	@JsonIgnore
	private boolean credentialNoExpired;
	@JsonIgnore
	private Set<RoleDto> roles;
}

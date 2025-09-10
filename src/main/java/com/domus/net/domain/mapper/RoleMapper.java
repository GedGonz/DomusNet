package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.RoleDto;
import com.domus.net.infrastructure.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

	RoleDto roleToRoleDto(Role role);

	Role roleDtoToRole(RoleDto roleDto);

	List<Role> roleDtoToRole(List<RoleDto> roleDtos);
	List<RoleDto> roleToRoleDto(List<Role> roles);

}
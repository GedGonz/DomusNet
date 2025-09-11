package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.PermissionDto;
import com.domus.net.infrastructure.entity.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

	PermissionDto permissionToPermissionDto(Permission permission);

	Permission permissionDtoToPermission(PermissionDto permissionDto);

	List<Permission> permissionDtoToPermission(List<PermissionDto> permissionDtos);
	List<PermissionDto> permissionToPermissionDto(List<Permission> permissions);

}
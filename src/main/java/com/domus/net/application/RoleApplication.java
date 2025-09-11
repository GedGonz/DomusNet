package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.RoleDto;
import com.domus.net.domain.service.RoleService;

import java.util.List;

@Application
public class RoleApplication {

	private final RoleService roleService;

	public RoleApplication(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<RoleDto> findRoleByRoleEnumIn(List<String> roleNames){
		return roleService.findRoleByRoleEnumIn(roleNames);
	}

}

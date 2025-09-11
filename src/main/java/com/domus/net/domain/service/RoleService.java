package com.domus.net.domain.service;

import com.domus.net.domain.dto.RoleDto;
import com.domus.net.domain.mapper.RoleMapper;
import com.domus.net.domain.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

	private final RoleRepository roleRepository;
	private final RoleMapper roleMapper;

	public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
		this.roleRepository = roleRepository;
		this.roleMapper = roleMapper;
	}

	public List<RoleDto> findRoleByRoleEnumIn(List<String> roleNames) {
		return roleMapper.roleToRoleDto(roleRepository.findRoleByRoleEnumIn(roleNames));
	}

}

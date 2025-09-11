package com.domus.net.domain.repository;

import com.domus.net.domain.repository.base.baseRepository;
import com.domus.net.infrastructure.entity.Role;

import java.util.List;


public interface RoleRepository extends baseRepository<Role> {

	List<Role> findRoleByRoleEnumIn(List<String> roleNames);
}

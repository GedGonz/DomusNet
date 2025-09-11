package com.domus.net.infrastructure.jpaentity;

import com.domus.net.infrastructure.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaRoleRepository extends JpaRepository<Role,Long> {
	List<Role> findRoleByRoleEnumIn(List<String> roleNames);
}

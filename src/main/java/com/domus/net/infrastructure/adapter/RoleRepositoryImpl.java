package com.domus.net.infrastructure.adapter;

import com.domus.net.domain.repository.RoleRepository;
import com.domus.net.infrastructure.entity.Role;
import com.domus.net.infrastructure.jpaentity.JpaRoleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
@Repository
public class RoleRepositoryImpl implements RoleRepository {

	private final JpaRoleRepository jpaRoleRepository;

	public RoleRepositoryImpl(JpaRoleRepository jpaRoleRepository) {
		this.jpaRoleRepository = jpaRoleRepository;
	}

	@Override
	public List<Role> findRoleByRoleEnumIn(List<String> roleNames) {
		return jpaRoleRepository.findRoleByRoleEnumIn(roleNames);
	}

	@Override
	public boolean exist(Long id) {
		return false;
	}

	@Override
	public Page<Role> getAll(Pageable pageable) {
		return null;
	}

	@Override
	public Role getFindById(Long id) {
		return null;
	}

	@Override
	public void saveAll(List<Role> roles) {

	}

	@Override
	public Role save(Role role) {
		return null;
	}

	@Override
	public void delete(Long id) {

	}
}

package com.domus.net.domain.repository.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface baseRepository<Entity> {

	boolean exist(Long id);
	Page<Entity> getAll(Pageable pageable);
	Entity getFindById(Long id);
	void saveAll(List<Entity> entities);
	Entity save (Entity entity);
	void delete(Long id);
}

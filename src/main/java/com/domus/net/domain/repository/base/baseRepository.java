package com.domus.net.domain.repository.base;

import java.util.List;

public interface baseRepository<Entity> {

	boolean exist(Long id);

	List<Entity> getAll();
	Entity getFindById(Long id);
	void saveAll(List<Entity> entities);
	Entity save (Entity entity);
	void delete(Long id);
}

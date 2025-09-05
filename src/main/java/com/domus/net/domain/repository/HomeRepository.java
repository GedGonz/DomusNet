package com.domus.net.domain.repository;

import com.domus.net.domain.repository.base.baseRepository;
import com.domus.net.infrastructure.entity.Home;


public interface HomeRepository extends baseRepository<Home> {
	boolean existNumber(String number);
}

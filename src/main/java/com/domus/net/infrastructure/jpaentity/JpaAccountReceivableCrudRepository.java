package com.domus.net.infrastructure.jpaentity;

import com.domus.net.infrastructure.entity.AccountsReceivable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface JpaAccountReceivableCrudRepository extends JpaRepository<AccountsReceivable,Long> {

	@Query(value = "SELECT generate_monthly_debt(:date)", nativeQuery = true)
	void generateMonthlyDebt(@Param("date") LocalDate date);
}
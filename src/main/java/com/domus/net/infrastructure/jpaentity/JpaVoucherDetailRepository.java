package com.domus.net.infrastructure.jpaentity;

import com.domus.net.infrastructure.entity.VoucherDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaVoucherDetailRepository extends JpaRepository<VoucherDetail,Long> {

}

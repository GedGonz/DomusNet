package com.domus.net.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "voucher_detail")
public class VoucherDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voucher_detail_seq")
	@SequenceGenerator(name = "voucher_detail_seq", sequenceName = "voucher_detail_seq", allocationSize = 1)
	private Long id;

	@Column(nullable = false, length = 100)
	private String concept;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal amount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voucher_id", nullable = false)
	private Voucher voucher;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parameter_id", nullable = false)
	private Parameter parameter;
}

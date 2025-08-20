package com.domus.net.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pay")
public class Pay {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pay_seq")
	@SequenceGenerator(name = "pay_seq", sequenceName = "pay_seq", allocationSize = 1)
	private Integer id;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal amount;

	@Column(name = "date_record", nullable = false)
	private LocalDate dateRecord;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voucher_id", nullable = false)
	private Voucher voucher;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "home_id", nullable = false)
	private Home home;
}
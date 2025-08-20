package com.domus.net.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "voucher")
public class Voucher {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voucher_seq")
	@SequenceGenerator(name = "voucher_seq", sequenceName = "voucher_seq", allocationSize = 1)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String concept;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal amount;

	@Column(name = "num_reference", nullable = false)
	private Integer numReference;

	@Column(nullable = false, length = 100)
	private String photo;

	@Column(name = "date_record", nullable = false)
	private LocalDate dateRecord;

	@Column(name = "period_init", nullable = false)
	private LocalDate periodInit;

	@Column(name = "period_end", nullable = false)
	private LocalDate periodEnd;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "home_id", nullable = false)
	private Home home;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_voucher_id", nullable = false)
	private TypeVoucher typeVoucher;

	@OneToMany(mappedBy = "voucher", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<VoucherDetail> details;
}
package com.domus.net.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "accounts_receivable")
public class AccountsReceivable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accounts_receivable_seq")
	@SequenceGenerator(name = "accounts_receivable_seq", sequenceName = "accounts_receivable_seq", allocationSize = 1)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String concept;

	@Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal totalAmount;

	@Column(name = "paid_amount", precision = 10, scale = 2)
	private BigDecimal paidAmount;

	@Column(name = "due_date", nullable = false)
	private LocalDate dueDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "home_id", nullable = false)
	private Home home;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parameter_id", nullable = false)
	private Parameter parameter;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id", nullable = false)
	private TypeStateAccountsReceivable state;
}
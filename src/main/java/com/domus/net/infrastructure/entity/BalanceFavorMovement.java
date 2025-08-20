package com.domus.net.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "balance_favor_movement")
public class BalanceFavorMovement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balance_favor_movement_seq")
	@SequenceGenerator(name = "balance_favor_movement_seq", sequenceName = "balance_favor_movement_seq", allocationSize = 1)
	private Integer id;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal amount;

	@Column(length = 200)
	private String concept;

	@Column(name = "date_record")
	private LocalDateTime dateRecord;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "home_id", nullable = false)
	private Home home;
}
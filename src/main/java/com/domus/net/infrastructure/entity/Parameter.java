package com.domus.net.infrastructure.entity;

import com.domus.net.infrastructure.enums.TypeStateEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "parameter")
public class Parameter {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parameter_seq")
	@SequenceGenerator(name = "parameter_seq", sequenceName = "parameter_seq", allocationSize = 1)
	public Long id;

	@Column(nullable = false, length = 100)
	private String concept;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal amount;

	@Column(name = "date_record", nullable = false)
	private LocalDate dateRecord;

	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	private TypeStateEnum state;

}

package com.domus.net.infrastructure.entity;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String concept;
	public BigDecimal amount;

	@Column(name = "date_record")
	public LocalDate dateRecord;

	@ManyToOne()
	@JoinColumn(name = "state_id")
	public TypeState typeState;
}

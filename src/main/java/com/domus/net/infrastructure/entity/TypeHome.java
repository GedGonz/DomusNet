package com.domus.net.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "type_home")
public class TypeHome {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String name;
	public String description;
	public BigDecimal discount;

	@ManyToOne()
	@JoinColumn(name = "state_id")
	public TypeState typeState;
}

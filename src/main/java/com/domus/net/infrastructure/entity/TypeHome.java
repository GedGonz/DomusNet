package com.domus.net.infrastructure.entity;

import com.domus.net.infrastructure.enums.TypeStateEnum;
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

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, length = 50)
	private String description;

	@Column(nullable = false, precision = 2, scale = 1)
	private BigDecimal discount;

	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	private TypeStateEnum state;

}

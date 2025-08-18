package com.domus.net.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "home")
public class Home {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String number;
	public String model;

	@ManyToOne()
	@JoinColumn(name = "state_id")
	public TypeState typeState;

	@ManyToOne()
	@JoinColumn(name = "type_home_id")
	public TypeHome typeHome;

	@ManyToOne()
	@JoinColumn(name = "residence_id")
	public Residence residence;
}

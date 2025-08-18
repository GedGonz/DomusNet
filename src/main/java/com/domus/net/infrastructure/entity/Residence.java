package com.domus.net.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "residence")
public class Residence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String name;
	public String location;
	public Integer telephone;
	@Column(name = "funding_date")
	public LocalDate fundingDate;
}

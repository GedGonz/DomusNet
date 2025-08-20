package com.domus.net.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "residence")
public class Residence {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "residence_seq")
	@SequenceGenerator(name = "residence_seq", sequenceName = "residence_seq", allocationSize = 1)
	public Long id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 100)
	private String location;

	@Column(nullable = false)
	private Integer telephone;

	@Column(name = "funding_date", nullable = false)
	private LocalDate fundingDate;

	@OneToMany(mappedBy = "residence")
	private Set<Home> homes;

	@OneToMany(mappedBy = "residence")
	private Set<Project> projects;
}

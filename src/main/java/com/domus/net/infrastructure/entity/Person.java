package com.domus.net.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
	@SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 1)
	public Long id;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, length = 50)
	private String lastname;

	@Column(nullable = false)
	private Integer phone1;

	@Column(nullable = false, length = 100)
	private String email1;

	@Column(nullable = false)
	private Integer phone2;

	@Column(nullable = false, length = 100)
	private String email2;

	@ManyToMany(mappedBy = "persons")
	private Set<Home> homes = new HashSet<>();
}

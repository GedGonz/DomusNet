package com.domus.net.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "home")
public class Home {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "home_seq")
	@SequenceGenerator(name = "home_seq", sequenceName = "home_seq", allocationSize = 1)
	public Long id;


	@Column(nullable = false, length = 10)
	private String number;

	@Column(nullable = false, length = 50)
	private String model;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id", nullable = false)
	private TypeState state;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "residence_id", nullable = false)
	private Residence residence;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_home_id", nullable = false)
	private TypeHome typeHome;

	@ManyToMany
	@JoinTable(
			name = "home_person",
			joinColumns = @JoinColumn(name = "home_id"),
			inverseJoinColumns = @JoinColumn(name = "person_id")
	)
	private Set<Person> persons = new HashSet<>();

}

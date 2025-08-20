package com.domus.net.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
	public Long id;

	@Column(nullable = false, length = 50)
	private String username;

	@Column(nullable = false, length = 50)
	private String password;

	@Column(name = "date_record", nullable = false)
	private LocalDate dateRecord;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id", nullable = false)
	private TypeState state;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = false, unique = true)
	private Person person;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

}

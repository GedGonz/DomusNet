package com.domus.net.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
	public Long id;

	@Column(nullable = false, length = 50, unique = true)
	private String username;

	@Column(nullable = false, length = 100)
	private String password;

	@Column(name = "is_enabled")
	private boolean enabled;

	@Column(name = "account_No_Expired")
	private boolean accountNoExpired;

	@Column(name="account_No_Locked")
	private boolean accountNoLocked;

	@Column(name = "credential_No_Expired")
	private boolean credentialNoExpired;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id", nullable = false)
	private TypeState state;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = false, unique = true)
	private Person person;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

}

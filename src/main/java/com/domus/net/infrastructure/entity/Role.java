package com.domus.net.infrastructure.entity;

import com.domus.net.infrastructure.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	@SequenceGenerator(name = "role_seq", sequenceName = "role_seq", allocationSize = 1)
	public Long id;

	@Column(name = "role_name")
	@Enumerated(EnumType.STRING)
	private RoleEnum roleEnum;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "role_permisions", joinColumns = @JoinColumn(name = "rol_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private Set<Permission> permissions;

}

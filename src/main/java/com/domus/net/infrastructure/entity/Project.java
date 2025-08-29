package com.domus.net.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
	@SequenceGenerator(name = "project_seq", sequenceName = "project_seq", allocationSize = 1)
	public Long id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 150)
	private String description;

	@Column(name = "date_init", nullable = false)
	private LocalDate dateInit;

	@Column(name = "date_end", nullable = false)
	private LocalDate dateEnd;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "residence_id", nullable = false)
	private Residence residence;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id", nullable = false)
	private TypeState state;

}

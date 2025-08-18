package com.domus.net.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "type_state_accounts_receivable")
public class TypeStateAccountsReceivable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String name;
	public String description;
}

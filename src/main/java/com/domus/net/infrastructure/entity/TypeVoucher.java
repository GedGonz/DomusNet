package com.domus.net.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "type_voucher")
public class TypeVoucher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String name;
	public String description;
	@Column(name = "date_record")
	public LocalDate dateRecord;
}

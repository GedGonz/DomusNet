package com.domus.net.domain.enums;

import lombok.Getter;

@Getter
public enum TypeVoucher {
	TRANSFER(1L),
	BANK_DEPOSIT(2L);

	private final Long value;

	TypeVoucher(Long value) {
		this.value = value;
	}

}
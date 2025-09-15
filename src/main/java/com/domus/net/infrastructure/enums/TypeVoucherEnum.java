package com.domus.net.infrastructure.enums;

public enum TypeVoucherEnum {

	TRANSFER(1),
	BANK_DEPOSIT(2);

	private final Integer value;

	TypeVoucherEnum(Integer value) {
		this.value = value;
	}

}

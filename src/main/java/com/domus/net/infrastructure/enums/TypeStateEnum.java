package com.domus.net.infrastructure.enums;

import lombok.Getter;

@Getter
public enum TypeStateEnum {
	ACTIVE(1),
	INACTIVE(2);

	private final Integer value;

	TypeStateEnum(Integer value) {
		this.value = value;
	}

}
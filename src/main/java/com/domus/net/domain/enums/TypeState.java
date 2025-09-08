package com.domus.net.domain.enums;

import lombok.Getter;

@Getter
public enum TypeState {
	ACTIVE(1L),
	INACTIVE(2L);

	private final Long value;

	TypeState(Long value) {
		this.value = value;
	}

}
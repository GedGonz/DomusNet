package com.domus.net.web.utils;

import java.time.LocalDateTime;

public class ApiResponse<T> {

	private final LocalDateTime timestamp;
	private final int status;
	private final String message;
	private final T data;

	public ApiResponse(int status, String message, T data) {
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	// Getters para los campos (no se necesitan setters ya que el objeto es inmutable)
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}
}
package com.domus.net.web.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ResponseBase {

	public static ResponseEntity<byte[]> createByteArrayResponse(byte[] bytes){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
	}
}

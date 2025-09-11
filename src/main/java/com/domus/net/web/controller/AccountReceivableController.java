package com.domus.net.web.controller;

import com.domus.net.application.AccountReceivableApplication;
import com.domus.net.domain.dto.AccountsReceivableDto;
import com.domus.net.web.utils.ApiResponse;
import com.domus.net.web.utils.PageResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@Log4j2
@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/accountReceivable")
public class AccountReceivableController {

	private final AccountReceivableApplication accountReceivableApplication;

	public AccountReceivableController(AccountReceivableApplication accountReceivableApplication) {
		this.accountReceivableApplication = accountReceivableApplication;
	}

	@GetMapping("")
	public ResponseEntity<ApiResponse<PageResponse<AccountsReceivableDto>>> getAll(Pageable pageable){
		var pageResponse = new PageResponse<>(accountReceivableApplication.getAll(pageable));
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", pageResponse);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<String>> delete(@PathVariable("id") Long id) throws Exception {
		accountReceivableApplication.delete(id);
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", "true");
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}

package com.domus.net.web.controller;

import com.domus.net.application.AccountReceivableApplication;
import com.domus.net.domain.dto.AccountsReceivableDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Log4j2
@RestController
@RequestMapping("/accountReceivable")
public class AccountReceivableController {

	private final AccountReceivableApplication accountReceivableApplication;

	public AccountReceivableController(AccountReceivableApplication accountReceivableApplication) {
		this.accountReceivableApplication = accountReceivableApplication;
	}

	@GetMapping("")
	public ResponseEntity<Page<AccountsReceivableDto>> getAll(Pageable pageable){
		return new ResponseEntity<>(accountReceivableApplication.getAll(pageable), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
		accountReceivableApplication.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}

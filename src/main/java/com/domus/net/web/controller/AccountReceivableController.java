package com.domus.net.web.controller;

import com.domus.net.application.AccountReceivableApplication;
import com.domus.net.domain.dto.AccountsReceivableDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController
@RequestMapping("/accountReceivable")
public class AccountReceivableController {

	private final AccountReceivableApplication accountReceivableApplication;

	public AccountReceivableController(AccountReceivableApplication accountReceivableApplication) {
		this.accountReceivableApplication = accountReceivableApplication;
	}


	@GetMapping("")
	public ResponseEntity<List<AccountsReceivableDto>> getAll(){
		return new ResponseEntity<>(accountReceivableApplication.getAll(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
		accountReceivableApplication.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}

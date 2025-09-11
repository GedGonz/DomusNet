package com.domus.net.web.controller;

import com.domus.net.application.VoucherApplication;
import com.domus.net.domain.dto.VoucherDto;
import com.domus.net.web.utils.ApiResponse;
import com.domus.net.web.utils.PageResponse;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Log4j2
@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/voucher")
public class VoucherController {

	private final VoucherApplication voucherApplication;

	public VoucherController(VoucherApplication voucherApplication) {
		this.voucherApplication = voucherApplication;
	}

	@GetMapping("")
	public ResponseEntity<ApiResponse<PageResponse<VoucherDto>>> getAll(Pageable pageable){
		var pageResponse = new PageResponse<>(voucherApplication.getAll(pageable));
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", pageResponse);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<VoucherDto>> getFindById(@PathVariable("id") Long id){
		var result = voucherApplication.findById(id);
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", result);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("revert/{id}")
	public ResponseEntity<ApiResponse<String>> revert(@PathVariable("id") Long id) {
		var result = voucherApplication.revertAccountsReceivable(id);
		if(result.contains("Error"))
			return new ResponseEntity<>(new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), result, null), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(), "", result), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<ApiResponse<VoucherDto>> save(@Valid @ModelAttribute VoucherDto voucherDto) throws Exception {

		if(voucherApplication.existNumReference(voucherDto.getNumReference())){
			log.warn("el number de referencia {} ya exist", voucherDto.getNumReference());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		VoucherDto voucherSaved = voucherApplication.save(voucherDto);

		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", voucherSaved);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse<VoucherDto>> update(@PathVariable Long id, @Valid @ModelAttribute VoucherDto voucherDto) throws Exception {

		if (!id.equals(voucherDto.getId())) {
			return ResponseEntity.badRequest().build();
		}

		if (voucherApplication.findById(id)==null) {
			log.warn("El voucher con ID {} no existe para ser actualizada", id);
			return ResponseEntity.notFound().build();
		}
		voucherDto.setId(id);
		VoucherDto voucherUpdated = voucherApplication.save(voucherDto);
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", voucherUpdated);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<String>> delete(@PathVariable("id") Long id) throws Exception {
		voucherApplication.delete(id);
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", "true");
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}

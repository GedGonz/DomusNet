package com.domus.net.web.controller;

import com.domus.net.application.VoucherApplication;
import com.domus.net.domain.dto.VoucherDto;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@Log4j2
@RestController
@RequestMapping("/voucher")
public class VoucherController {

	private final VoucherApplication voucherApplication;

	public VoucherController(VoucherApplication voucherApplication) {
		this.voucherApplication = voucherApplication;
	}


	@GetMapping("")
	public ResponseEntity<Page<VoucherDto>> getAll(Pageable pageable){
		return new ResponseEntity<>(voucherApplication.getAll(pageable), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<VoucherDto> getFindById(@PathVariable("id") Long id){
		return new ResponseEntity<>(voucherApplication.findById(id), HttpStatus.OK);
	}

	@GetMapping("revert/{id}")
	public ResponseEntity<String> revert(@PathVariable("id") Long id) {
		var result = voucherApplication.revertAccountsReceivable(Integer.parseInt(id.toString()));
		if(result.contains("Error"))
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PostMapping("/save")
	public ResponseEntity<VoucherDto> save(@Valid @ModelAttribute VoucherDto voucherDto) throws Exception {

		if(voucherApplication.existNumReference(voucherDto.getNumReference())){
			log.warn("el number de referencia {} ya exist", voucherDto.getNumReference());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		VoucherDto voucherSaved = voucherApplication.save(voucherDto);

		return new ResponseEntity<>(voucherSaved, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<VoucherDto> update(@PathVariable Long id, @Valid @ModelAttribute VoucherDto voucherDto) throws Exception {

		if (!id.equals(voucherDto.getId())) {
			return ResponseEntity.badRequest().build();
		}

		if (voucherApplication.findById(id)==null) {
			log.warn("El voucher con ID {} no existe para ser actualizada", id);
			return ResponseEntity.notFound().build();
		}
		VoucherDto voucherUpdated = voucherApplication.save(voucherDto);
		return new ResponseEntity<>(voucherUpdated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
		voucherApplication.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}

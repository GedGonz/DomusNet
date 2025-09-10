package com.domus.net.web.controller;

import com.domus.net.application.ParameterApplication;
import com.domus.net.domain.dto.ParameterDto;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Log4j2
@RestController
@RequestMapping("/parameter")
public class ParameterController {

	private final ParameterApplication parameterApplication;

	public ParameterController(ParameterApplication parameterApplication) {
		this.parameterApplication = parameterApplication;
	}

	@GetMapping("")
	public ResponseEntity<Page<ParameterDto>> getAll(Pageable pageable){
		return new ResponseEntity<>(parameterApplication.getAll(pageable), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ParameterDto> getFindById(@PathVariable("id") Long id){
		return new ResponseEntity<>(parameterApplication.findById(id), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<ParameterDto> save(@Valid @RequestBody ParameterDto parameterDto){

		if(parameterApplication.existConcept(parameterDto.getConcept())){
			log.warn("el concepto con nombre {} ya exist", parameterDto.getConcept());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		ParameterDto parameterSaved = parameterApplication.save(parameterDto);

		return new ResponseEntity<>(parameterSaved, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ParameterDto> update(@PathVariable Long id, @Valid @RequestBody ParameterDto parameterDto) {

		if (!id.equals(parameterDto.getId())) {
			return ResponseEntity.badRequest().build();
		}

		if (parameterApplication.findById(id)==null) {
			log.warn("El parametro con ID {} no existe para ser actualizada", id);
			return ResponseEntity.notFound().build();
		}
		ParameterDto parameterUpdated = parameterApplication.save(parameterDto);
		return new ResponseEntity<>(parameterUpdated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
		parameterApplication.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}

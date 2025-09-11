package com.domus.net.web.controller;

import com.domus.net.application.ParameterApplication;
import com.domus.net.domain.dto.ParameterDto;
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
@RequestMapping("/parameter")
public class ParameterController {

	private final ParameterApplication parameterApplication;

	public ParameterController(ParameterApplication parameterApplication) {
		this.parameterApplication = parameterApplication;
	}

	@GetMapping("")
	public ResponseEntity<ApiResponse<PageResponse<ParameterDto>>> getAll(Pageable pageable){

		var pageResponse = new PageResponse<>(parameterApplication.getAll(pageable));
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", pageResponse);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<ParameterDto>> getFindById(@PathVariable("id") Long id){

		var result = parameterApplication.findById(id);
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", result);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<ApiResponse<ParameterDto>> save(@Valid @RequestBody ParameterDto parameterDto){

		if(parameterApplication.existConcept(parameterDto.getConcept())){
			log.warn("el concepto con nombre {} ya exist", parameterDto.getConcept());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		ParameterDto parameterSaved = parameterApplication.save(parameterDto);

		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", parameterSaved);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse<ParameterDto>> update(@PathVariable Long id, @Valid @RequestBody ParameterDto parameterDto) {

		if (!id.equals(parameterDto.getId())) {
			return ResponseEntity.badRequest().build();
		}

		if (parameterApplication.findById(id)==null) {
			log.warn("El parametro con ID {} no existe para ser actualizada", id);
			return ResponseEntity.notFound().build();
		}
		ParameterDto parameterUpdated = parameterApplication.save(parameterDto);

		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", parameterUpdated);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<String>> delete(@PathVariable("id") Long id) throws Exception {

		parameterApplication.delete(id);
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", "true");

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}

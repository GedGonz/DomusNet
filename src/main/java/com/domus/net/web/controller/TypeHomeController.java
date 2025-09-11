package com.domus.net.web.controller;

import com.domus.net.application.TypeHomeApplication;
import com.domus.net.domain.dto.TypeHomeDto;
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
@RequestMapping("/typeHome")
public class TypeHomeController {

	private final TypeHomeApplication typeHomeApplication;

	public TypeHomeController(TypeHomeApplication typeHomeApplication) {
		this.typeHomeApplication = typeHomeApplication;
	}

	@GetMapping("")
	public ResponseEntity<ApiResponse<PageResponse<TypeHomeDto>>> getAll(Pageable pageable){
		var pageResponse = new PageResponse<>(typeHomeApplication.getAll(pageable));
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", pageResponse);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<TypeHomeDto>> getFindById(@PathVariable("id") Long id){
		var result = typeHomeApplication.findById(id);
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", result);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<ApiResponse<TypeHomeDto>> save(@Valid @RequestBody TypeHomeDto typeHomeDto){

		if(typeHomeApplication.existName(typeHomeDto.getName())){
			log.warn("El tipo de casa con nombre {} ya exist", typeHomeDto.getName());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		TypeHomeDto typeHomeSaved = typeHomeApplication.save(typeHomeDto);

		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", typeHomeSaved);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse<TypeHomeDto>> update(@PathVariable Long id, @Valid @RequestBody TypeHomeDto typeHomeDto) {

		if (!id.equals(typeHomeDto.getId())) {
			return ResponseEntity.badRequest().build();
		}

		if (typeHomeApplication.findById(id)==null) {
			log.warn("El tipo de casa con ID {} no existe para ser actualizada", id);
			return ResponseEntity.notFound().build();
		}
		TypeHomeDto typeHomeUpdated = typeHomeApplication.save(typeHomeDto);
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", typeHomeUpdated);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<String>> delete(@PathVariable("id") Long id) throws Exception {
		typeHomeApplication.delete(id);
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", "true");
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}

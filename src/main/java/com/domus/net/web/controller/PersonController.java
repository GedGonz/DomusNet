package com.domus.net.web.controller;

import com.domus.net.application.PersonApplication;
import com.domus.net.domain.dto.PersonDto;
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
@RequestMapping("/person")
public class PersonController {

	private final PersonApplication personApplication;

	public PersonController(PersonApplication personApplication) {
		this.personApplication = personApplication;
	}

	@GetMapping("")
	public ResponseEntity<ApiResponse<PageResponse<PersonDto>>> getAll(Pageable pageable){

		var pageResponse = new PageResponse<>(personApplication.getAll(pageable));
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", pageResponse);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<PersonDto>> getFindById(@PathVariable("id") Long id){

		var result = personApplication.findById(id);
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", result);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<ApiResponse<PersonDto>> save(@Valid @RequestBody PersonDto personDto){

		PersonDto personSaved = personApplication.save(personDto);

		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", personSaved);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse<PersonDto>> update(@PathVariable Long id, @Valid @RequestBody PersonDto personDto) {

		if (!id.equals(personDto.getId())) {
			return ResponseEntity.badRequest().build();
		}

		if (personApplication.findById(id)==null) {
			log.warn("La persona con ID {} no existe para ser actualizada", id);
			return ResponseEntity.notFound().build();
		}

		PersonDto personUpdated = personApplication.save(personDto);

		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", personUpdated);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<String>> delete(@PathVariable("id") Long id) throws Exception {

		personApplication.delete(id);
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "","true");

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}

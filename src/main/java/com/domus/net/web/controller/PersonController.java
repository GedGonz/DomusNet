package com.domus.net.web.controller;

import com.domus.net.application.PersonApplication;
import com.domus.net.domain.dto.PersonDto;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController
@RequestMapping("/person")
public class PersonController {

	private final PersonApplication personApplication;

	public PersonController(PersonApplication personApplication) {
		this.personApplication = personApplication;
	}

	@GetMapping("")
	public ResponseEntity<List<PersonDto>> getAll(){
		return new ResponseEntity<>(personApplication.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersonDto> getFindById(@PathVariable("id") Long id){
		return new ResponseEntity<>(personApplication.findById(id), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<PersonDto> save(@Valid @RequestBody PersonDto personDto){

		PersonDto personSaved = personApplication.save(personDto);

		return new ResponseEntity<>(personSaved, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<PersonDto> update(@PathVariable Long id, @Valid @RequestBody PersonDto personDto) {

		if (!id.equals(personDto.getId())) {
			return ResponseEntity.badRequest().build();
		}

		if (personApplication.findById(id)==null) {
			log.warn("La persona con ID {} no existe para ser actualizada", id);
			return ResponseEntity.notFound().build();
		}
		PersonDto personUpdated = personApplication.save(personDto);
		return new ResponseEntity<>(personUpdated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
		personApplication.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}

package com.domus.net.web.controller;

import com.domus.net.application.TypeHomeApplication;
import com.domus.net.domain.dto.TypeHomeDto;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController
@RequestMapping("/typeHome")
public class TypeHomeController {

	private final TypeHomeApplication typeHomeApplication;

	public TypeHomeController(TypeHomeApplication typeHomeApplication) {
		this.typeHomeApplication = typeHomeApplication;
	}

	@GetMapping("")
	public ResponseEntity<List<TypeHomeDto>> getAll(){
		return new ResponseEntity<>(typeHomeApplication.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TypeHomeDto> getFindById(@PathVariable("id") Long id){
		return new ResponseEntity<>(typeHomeApplication.findById(id), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<TypeHomeDto> save(@Valid @RequestBody TypeHomeDto typeHomeDto){

		if(typeHomeApplication.existName(typeHomeDto.getName())){
			log.warn("El tipo de casa con nombre {} ya exist", typeHomeDto.getName());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		TypeHomeDto typeHomeSaved = typeHomeApplication.save(typeHomeDto);

		return new ResponseEntity<>(typeHomeSaved, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<TypeHomeDto> update(@PathVariable Long id, @Valid @RequestBody TypeHomeDto typeHomeDto) {

		if (!id.equals(typeHomeDto.getId())) {
			return ResponseEntity.badRequest().build();
		}

		if (typeHomeApplication.findById(id)==null) {
			log.warn("El tipo de casa con ID {} no existe para ser actualizada", id);
			return ResponseEntity.notFound().build();
		}
		TypeHomeDto typeHomeUpdated = typeHomeApplication.save(typeHomeDto);
		return new ResponseEntity<>(typeHomeUpdated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
		typeHomeApplication.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}

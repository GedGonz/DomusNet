package com.domus.net.web.controller;

import com.domus.net.application.HomeApplication;
import com.domus.net.application.ResidenceApplication;
import com.domus.net.domain.dto.HomeDto;
import com.domus.net.domain.dto.ResidenceDto;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController
@RequestMapping("/residence")
public class ResidenceController {

	private final ResidenceApplication residenceApplication;

	public ResidenceController(ResidenceApplication residenceApplication) {
		this.residenceApplication = residenceApplication;
	}

	@GetMapping("")
	public ResponseEntity<List<ResidenceDto>> getAll(){
		return new ResponseEntity<>(residenceApplication.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResidenceDto> getFindById(@PathVariable("id") Long id){
		return new ResponseEntity<>(residenceApplication.findById(id), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<ResidenceDto> save(@Valid @RequestBody ResidenceDto residenceDto){

		if(residenceApplication.existName(residenceDto.getName())){
			log.warn("la residencia con nombre {} ya exist", residenceDto.getName());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		ResidenceDto residenceSaved = residenceApplication.save(residenceDto);

		return new ResponseEntity<>(residenceSaved, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResidenceDto> update(@PathVariable Long id, @Valid @RequestBody ResidenceDto residenceDto) {

		if (!id.equals(residenceDto.getId())) {
			return ResponseEntity.badRequest().build();
		}

		if (residenceApplication.findById(id)==null) {
			log.warn("La residencia con ID {} no existe para ser actualizada", id);
			return ResponseEntity.notFound().build();
		}
		ResidenceDto residenceUpdated = residenceApplication.save(residenceDto);
		return new ResponseEntity<>(residenceUpdated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
		residenceApplication.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}

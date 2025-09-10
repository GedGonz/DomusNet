package com.domus.net.web.controller;

import com.domus.net.application.HomeApplication;
import com.domus.net.domain.dto.HomeDto;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Log4j2
@RestController
@RequestMapping("/home")
public class HomeController {

	private final HomeApplication homeApplication;

	public HomeController(HomeApplication homeApplication) {
		this.homeApplication = homeApplication;
	}


	@GetMapping("")
	public ResponseEntity<Page<HomeDto>> getAll(Pageable pageable){
		return new ResponseEntity<>(homeApplication.getAll(pageable), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<HomeDto> getFindById(@PathVariable("id") Long id){
		return new ResponseEntity<>(homeApplication.findById(id), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<HomeDto> save(@Valid @RequestBody HomeDto homeDto){

		if(homeApplication.existNumber(homeDto.getNumber())){
			log.warn("la casa con id {} ya exist", homeDto.getNumber());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		HomeDto homeSaved = homeApplication.save(homeDto);

		return new ResponseEntity<>(homeSaved, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<HomeDto> update(@PathVariable Long id, @Valid @RequestBody HomeDto homeDto) {

		if (!id.equals(homeDto.getId())) {
			return ResponseEntity.badRequest().build();
		}

		if (homeApplication.findById(id)==null) {
			log.warn("La casa con ID {} no existe para ser actualizada", id);
			return ResponseEntity.notFound().build();
		}
		HomeDto homeUpdated = homeApplication.save(homeDto);
		return new ResponseEntity<>(homeUpdated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
		homeApplication.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}

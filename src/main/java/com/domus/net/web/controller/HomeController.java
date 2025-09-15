package com.domus.net.web.controller;

import com.domus.net.application.HomeApplication;
import com.domus.net.domain.dto.HomeDto;
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
@RequestMapping("/home")
public class HomeController {

	private final HomeApplication homeApplication;

	public HomeController(HomeApplication homeApplication) {
		this.homeApplication = homeApplication;
	}


	@GetMapping("")
	public ResponseEntity<ApiResponse<PageResponse<HomeDto>>> getAll(Pageable pageable) {

		var pageResponse = new PageResponse<>(homeApplication.getAll(pageable));
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", pageResponse);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<HomeDto>> getFindById(@PathVariable("id") Long id){

		var result = homeApplication.findById(id);
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", result);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<ApiResponse<HomeDto>> save(@Valid @RequestBody HomeDto homeDto){

		if(homeApplication.existNumber(homeDto.getNumber())){
			log.warn("la casa con id {} ya exist", homeDto.getNumber());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		HomeDto homeSaved = homeApplication.save(homeDto);

		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", homeSaved);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse<HomeDto>> update(@PathVariable Long id, @Valid @RequestBody HomeDto homeDto) {

		if (!id.equals(homeDto.getId())) {
			return ResponseEntity.badRequest().build();
		}

		if (homeApplication.findById(id)==null) {
			log.warn("La casa con ID {} no existe para ser actualizada", id);
			return ResponseEntity.notFound().build();
		}
		HomeDto homeUpdated = homeApplication.save(homeDto);

		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", homeUpdated);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<String>> delete(@PathVariable("id") Long id) throws Exception {

		homeApplication.delete(id);
		var apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "","true");

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}

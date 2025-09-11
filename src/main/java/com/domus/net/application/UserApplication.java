package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.UserDto;
import com.domus.net.domain.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Application
public class UserApplication {

	private final UserService userService;

	public UserApplication(UserService userService) {
		this.userService = userService;
	}

	public UserDto findById(Long id){
		return userService.findById(id);
	}
	public boolean exist(Long id){
		return userService.exist(id);
	}

	public Page<UserDto> getAll(Pageable pageable){
		return userService.getAll(pageable);
	}

	public UserDto save(UserDto personDto){
		return userService.save(personDto);
	}

	public UserDto getByUsername(String name){
		return userService.getByUsername(name);
	}

	public void delete(Long id){
		userService.delete(id);
	}
}

package com.domus.net.domain.service;

import com.domus.net.domain.dto.UserDto;
import com.domus.net.domain.mapper.UserMapper;
import com.domus.net.domain.repository.RoleRepository;
import com.domus.net.domain.repository.UserRepository;
import com.domus.net.infrastructure.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final UserMapper userMapper;

	public UserService(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userMapper = userMapper;
	}


	public UserDto findById(Long id){
		return userMapper.userToUserDto(userRepository.getFindById(id));
	}
	public boolean exist(Long id){
		return userRepository.exist(id);
	}

	public Page<UserDto> getAll(Pageable pageable){

		var usersPage = userRepository.getAll(pageable);

		List<UserDto> userDtoList = userMapper.userToUserDto(usersPage.getContent());
		return new PageImpl<>(userDtoList, usersPage.getPageable(), usersPage.getTotalElements());
	}

	public UserDto save(UserDto userDto){

		var user = userMapper.userDtoToUser(userDto);

		Set<Role> roles = new HashSet<>(roleRepository.findRoleByRoleEnumIn(userDto.getRoles().stream().map(role -> role.getRoleEnum().name()).toList()));
		user.setRoles(roles);

		var result= userRepository.save(user);
		return userMapper.userToUserDto(result);
	}

	public void delete(Long id){
		userRepository.delete(id);
	}


	public UserDto getByUsername(String username) {
		return userMapper.userToUserDto(userRepository.findByUsername(username).orElse(null));
	}

}

package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.UserDto;
import com.domus.net.infrastructure.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserDto userToUserDto(User user);
	User userDtoToUser(UserDto userDto);
	List<User> userDtoToUser(List<UserDto> userDtos);
	List<UserDto> userToUserDto(List<User> users);

}
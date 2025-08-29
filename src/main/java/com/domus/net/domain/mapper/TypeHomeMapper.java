package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.TypeHomeDto;
import com.domus.net.infrastructure.entity.TypeHome;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeHomeMapper {
	TypeHomeDto typehomeToTypeHomeDto(TypeHome typeHome);
	TypeHome typehomeDtoToTypeHome(TypeHomeDto typeHomeDto);
	List<TypeHome> typehomesDtoToTypeHomes(List<TypeHomeDto> typeHomeDtos);
	List<TypeHomeDto> typehomesToTypeHomesDto(List<TypeHome> typeHomes);
}
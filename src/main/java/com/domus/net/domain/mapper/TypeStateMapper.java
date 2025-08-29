package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.TypeStateDto;
import com.domus.net.infrastructure.entity.TypeState;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeStateMapper {
	TypeStateDto typeStateToTypeStateDto(TypeState typeState);
	TypeState typeStateDtoToTypeState(TypeStateDto typeStateDto);
	List<TypeState> typeStateDtoToTypeState(List<TypeStateDto> typeStateDtos);
	List<TypeStateDto> typeStateToTypeStateDto(List<TypeState> typeStates);
}
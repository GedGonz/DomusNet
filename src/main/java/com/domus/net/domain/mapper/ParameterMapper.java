package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.ParameterDto;
import com.domus.net.infrastructure.entity.Parameter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParameterMapper {


	ParameterDto parameterToParameterDto(Parameter parameter);

	Parameter parameterDtoToParameter(ParameterDto parameterDto);

	List<Parameter> parameterDtoToParameter(List<ParameterDto> parameterDtos);
	List<ParameterDto> parameterToParameterDto(List<Parameter> parameters);

}
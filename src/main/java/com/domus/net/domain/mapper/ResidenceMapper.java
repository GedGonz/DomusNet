package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.ResidenceDto;
import com.domus.net.infrastructure.entity.Residence;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResidenceMapper {

	ResidenceDto residenceToResidenceDto(Residence residence);
	Residence residenceDtoToResidence(ResidenceDto residenceDto);
	List<Residence> residenceDtoToResidence(List<ResidenceDto> residenceDtos);
	List<ResidenceDto> residenceToResidenceDto(List<Residence> residences);
}
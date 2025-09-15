package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.HomeDto;
import com.domus.net.domain.mapper.context.MappingContext;
import com.domus.net.infrastructure.entity.*;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HomeMapper {

	HomeDto homeToHomeDto(Home home);

	@Mappings({
			@Mapping(target = "residence", expression = "java(findResidence(homeDto.getResidence().getId(), context))"),
			@Mapping(target = "typeHome", expression = "java(findTypeHome(homeDto.getTypeHome().getId(), context))"),
	})
	Home homeDtoToHome(HomeDto homeDto, @Context MappingContext context);

	List<Home> homesDtoToHomes(List<HomeDto> homeDtos);
	List<HomeDto> homessToHomesDto(List<Home> homes);

	default Residence findResidence(Long id, MappingContext context) {
		return id != null ? context.getResidenceRepository().getFindById(id) : null;
	}
	default TypeHome findTypeHome(Long id, MappingContext context) {
		return id != null ? context.getTypeHomeRepository().getFindById(id) : null;
	}

}
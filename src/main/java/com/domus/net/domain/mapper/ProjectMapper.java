package com.domus.net.domain.mapper;

import com.domus.net.domain.dto.ProjectDto;
import com.domus.net.infrastructure.entity.*;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {


	ProjectDto projectToProjectDto(Project project);

	Project projectDtoToproject(ProjectDto projectDto);

	List<Project> projectDtoToProject(List<ProjectDto> projectDtos);
	List<ProjectDto> projectToProjectDto(List<Project> projects);

}
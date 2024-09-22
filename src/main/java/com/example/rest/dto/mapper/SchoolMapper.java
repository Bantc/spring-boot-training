package com.example.rest.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.rest.School;
import com.example.rest.dto.SchoolDto;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface SchoolMapper {
    SchoolMapper INSTANCE = Mappers.getMapper(SchoolMapper.class);

    SchoolDto schoolToSchoolDto(School school);
    School schoolDtoToSchool(SchoolDto schoolDto);
    List<SchoolDto> mapToList(List<School> schools);
}

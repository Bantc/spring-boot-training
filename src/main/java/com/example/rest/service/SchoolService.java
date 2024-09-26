package com.example.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rest.School;
import com.example.rest.SchoolRepository;
import com.example.rest.dto.SchoolDto;
import com.example.rest.dto.mapper.SchoolMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;

    public SchoolDto createSchool(SchoolDto schoolDto) {
        School school = schoolMapper.schoolDtoToSchool(schoolDto);
        schoolRepository.save(school);
        
        return schoolDto;
    }

    public List<SchoolDto> getSchools() {
        List<SchoolDto> schoolsDtos = schoolMapper.mapToList(schoolRepository.findAll());

        return schoolsDtos;
    }
}

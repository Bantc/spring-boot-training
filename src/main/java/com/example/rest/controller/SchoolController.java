package com.example.rest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.rest.School;
import com.example.rest.SchoolRepository;
import com.example.rest.dto.SchoolDto;
import com.example.rest.dto.mapper.SchoolMapper;
import com.example.rest.dto.mapper.StudentMapper;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SchoolController {
    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto) {
        School school = SchoolMapper.INSTANCE.schoolDtoToSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }
    
    @GetMapping("/schools")
    public List<SchoolDto> getSchools() {
        List<SchoolDto> schoolsDtos = SchoolMapper.INSTANCE.mapToList(schoolRepository.findAll());
        return schoolsDtos;
    }

}

package com.example.rest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.rest.School;
import com.example.rest.SchoolRepository;
import com.example.rest.dto.SchoolDto;
import com.example.rest.dto.mapper.SchoolMapper;
import com.example.rest.dto.mapper.StudentMapper;
import com.example.rest.service.SchoolService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping("/schools")
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.createSchool(schoolDto);
    }
    
    @GetMapping("/schools")
    public List<SchoolDto> getSchools() {
        return schoolService.getSchools();
    }

}

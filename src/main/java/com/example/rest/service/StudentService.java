package com.example.rest.service;

import org.springframework.stereotype.Service;

import com.example.rest.Student;
import com.example.rest.StudentRepository;
import com.example.rest.dto.StudentPostDto;
import com.example.rest.dto.StudentResponseDto;
import com.example.rest.dto.mapper.StudentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepo;
    private final StudentMapper studentMapper;

    public StudentResponseDto postResponse(StudentPostDto studentPostDto) {
        Student student = studentMapper.studentPostDtoToStudent(studentPostDto);
        return studentMapper.studentToStudentResponseDto(studentRepo.save(student));
    }

    public void delete(int studentId) {
        studentRepo.deleteById(studentId);
    }
}

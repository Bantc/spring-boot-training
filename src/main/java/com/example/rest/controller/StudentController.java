package com.example.rest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.rest.Student;
import com.example.rest.StudentRepository;
import com.example.rest.dto.StudentPostDto;
import com.example.rest.dto.StudentResponseDto;
import com.example.rest.dto.mapper.StudentMapper;
import com.example.rest.service.StudentService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    
    // //STUDENT POST DTO
    // @PostMapping("/students")
    // public Student post(@RequestBody StudentPostDto studentPostDto) {
    //     return studentService.post(studentPostDto);
    // }

    //STUDENT RESPONSE DTO
    @PostMapping("/students")
    public StudentResponseDto postResponse(@RequestBody StudentPostDto studentPostDto) {
        return studentService.postResponse(studentPostDto);
    }

    @DeleteMapping("/students/del/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") int studentId) {
        studentService.delete(studentId);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudent() {
        return studentService.findAllStudent();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto findStudentById(@PathVariable("student-id") int id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentByName(@PathVariable("student-name") String firstName) {
        return studentService.findStudentByName(firstName);
    }
}

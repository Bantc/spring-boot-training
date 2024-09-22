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

    private final StudentRepository studRepo;
    private final StudentService studentService;
    
    // //STUDENT POST DTO
    // @PostMapping("/students")
    // public Student post(@RequestBody StudentPostDto studentPostDto) {
    //     Student student = StudentMapper.INSTANCE.studentPostDtoToStudent(studentPostDto);
    //     return studRepo.save(student);
    // }

    //STUDENT RESPONSE DTO
    @PostMapping("/students")
    public StudentResponseDto postResponse(@RequestBody StudentPostDto studentPostDto) {
        return studentService.postResponse(studentPostDto);
    }

    @DeleteMapping("/students/del/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") int studentId) {
        studRepo.deleteById(studentId);
    }

    @GetMapping("/students")
    public List<Student> findAllStudent() {
        return studRepo.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(@PathVariable("student-id") int id) {
        return studRepo.findById(id)
                       .orElse(null);
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentById(@PathVariable("student-name") String firstName) {
        return studRepo.findAllByFirstnameContaining(firstName);
    }
}

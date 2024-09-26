package com.example.rest.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.rest.School;
import com.example.rest.Student;
import com.example.rest.dto.SchoolDto;
import com.example.rest.dto.StudentPostDto;
import com.example.rest.dto.StudentResponseDto;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentResponseDto studentToStudentResponseDto(Student student);
    default Student studentPostDtoToStudent(StudentPostDto studentPostDto) {
        Student student = new Student();
        School school = new School();
        school.setId(studentPostDto.schoolId());

        student.setFirstname(studentPostDto.firstname());
        student.setLastname(studentPostDto.lastname());
        student.setEmail(studentPostDto.email());
        student.setSchool(school);
        return student;
    };
    List<StudentResponseDto> mapToList(List<Student> students);
}
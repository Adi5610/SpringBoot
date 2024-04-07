package com.example.demo.restImpl.mappers;

import com.example.demo.restImpl.dto.ResponseStudentDto;
import com.example.demo.restImpl.dto.StudentDto;
import com.example.demo.restImpl.models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper studentMapper;


    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void ShouldMapStudentDtoToStudent(){

        StudentDto dto = new StudentDto("aditya", "magare","adi@gmail.com",1);

        Student student = studentMapper.toStudent(dto);

        assertEquals(dto.firstname(), student.getFirstName());
        assertEquals(dto.lastname(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());

    }

    @Test
    public void ShouldMapStudentToStudentResponseDto(){

        Student student = new Student("aditya", "magare","adi@gmail.com",22);

        ResponseStudentDto responseStudentDto = studentMapper.toResponseStudentDto(student);

        assertEquals(student.getFirstName(), responseStudentDto.firstName());
        assertEquals(student.getLastName(), responseStudentDto.lastName());
        assertEquals(student.getEmail(), responseStudentDto.email());


    }

}
package com.example.demo.restImpl.services;

import com.example.demo.restImpl.dto.ResponseStudentDto;
import com.example.demo.restImpl.dto.StudentDto;
import com.example.demo.restImpl.mappers.StudentMapper;
import com.example.demo.restImpl.models.Student;
import com.example.demo.restImpl.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository repository;

    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_save_student(){

        //Given
        Student student = new Student(
                "aditya",
                "magare",
                "adi@gmail.com",
                22
        );

        Student savedStudent = new Student(
                "aditya",
                "magare",
                "adi@gmail.com",
                22
        );

        StudentDto dto = new StudentDto(
                "aditya",
                "magare",
                "adi@gmail.com",
                1
        );

        Mockito.when(studentMapper.toStudent(dto)).thenReturn(student);
        Mockito.when(repository.save(student)).thenReturn(savedStudent);
        Mockito.when(studentMapper.toResponseStudentDto(savedStudent))
                .thenReturn(new ResponseStudentDto(
                        "aditya",
                        "magare",
                        "adi@gmail.com"
        ));


        //When
        ResponseStudentDto responseStudentDto = studentService.SaveStudent(dto);



        //Then
        assertEquals(responseStudentDto.firstName(), dto.firstname());
        assertEquals(responseStudentDto.lastName(), dto.lastname());
        assertEquals(responseStudentDto.email(), dto.email());
    }

}
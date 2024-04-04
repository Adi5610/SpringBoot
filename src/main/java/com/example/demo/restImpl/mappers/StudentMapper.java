package com.example.demo.restImpl.mappers;

import com.example.demo.restImpl.models.School;
import com.example.demo.restImpl.models.Student;
import com.example.demo.restImpl.dto.ResponseStudentDto;
import com.example.demo.restImpl.dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstName(dto.firstname());
        student.setLastName(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;

    }
    public ResponseStudentDto toResponseStudentDto(Student student){

        return new ResponseStudentDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );

    }
}

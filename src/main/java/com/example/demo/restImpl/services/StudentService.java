package com.example.demo.restImpl.services;

import com.example.demo.restImpl.mappers.StudentMapper;
import com.example.demo.restImpl.dto.ResponseStudentDto;
import com.example.demo.restImpl.dto.StudentDto;
import com.example.demo.restImpl.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;

    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public ResponseStudentDto SaveStudent(StudentDto dto){

        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.toResponseStudentDto(savedStudent);
    }

    public List<ResponseStudentDto> findAll(){
        return repository.findAll()
                .stream()
                .map(studentMapper::toResponseStudentDto)
                .collect(Collectors.toList());
    }

    public Optional<ResponseStudentDto> findById(Integer id){
        return repository.findById(id)
                .map(studentMapper::toResponseStudentDto);
    }

    public List<ResponseStudentDto> findAllByFirstName(String name){
        return repository.findAllByFirstNameContaining(name)
                .stream()
                .map(studentMapper::toResponseStudentDto)
                .collect(Collectors.toList());
    }
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}

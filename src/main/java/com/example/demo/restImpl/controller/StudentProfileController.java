package com.example.demo.restImpl.controller;

import com.example.demo.restImpl.models.StudentProfile;
import com.example.demo.restImpl.repository.StudentProfileRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentProfileController {

    private StudentProfileRepository repository;

    public StudentProfileController(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/studentProfile")
    public StudentProfile createStudentProfile(
            @RequestBody StudentProfile studentProfile){
        return repository.save(studentProfile);
    }

    @GetMapping("/studentProfile")
    public List<StudentProfile> getStudentProfile(){
        return repository.findAll();
    }
}

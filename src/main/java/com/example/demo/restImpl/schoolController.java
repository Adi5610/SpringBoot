package com.example.demo.restImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class schoolController {
    private SchoolRepository repository;

    public schoolController(SchoolRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/schools")
    public School createStudent(
            @RequestBody School school){
        return repository.save(school);
    }

    @GetMapping("/schools")
    public List<School> getStudent(){
        return repository.findAll();
    }
}

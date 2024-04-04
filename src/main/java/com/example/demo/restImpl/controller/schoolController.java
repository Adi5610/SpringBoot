package com.example.demo.restImpl.controller;

import com.example.demo.restImpl.dto.SchoolDto;
import com.example.demo.restImpl.dto.SchoolResponseDto;
import com.example.demo.restImpl.services.SchoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class schoolController {

    private final SchoolService service;

    public schoolController(SchoolService service) {
        this.service = service;
    }

    @PostMapping("/schools")
    public SchoolResponseDto createSchool(
            @RequestBody SchoolDto dto){
        return service.createSchool(dto);
    }

    @GetMapping("/schools")
    public List<SchoolResponseDto> getSchool(){
        return service.findAll();
    }
}

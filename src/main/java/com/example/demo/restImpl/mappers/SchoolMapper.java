package com.example.demo.restImpl.mappers;

import com.example.demo.restImpl.models.School;
import com.example.demo.restImpl.dto.SchoolDto;
import com.example.demo.restImpl.dto.SchoolResponseDto;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toSchool(SchoolDto dto ){

        var school = new School();
        school.setName(dto.name());
        return school;
    }

    public SchoolResponseDto schoolResponseDto(School school){

        return new SchoolResponseDto(school.getName());
    }
}

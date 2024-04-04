package com.example.demo.restImpl.services;

import com.example.demo.restImpl.mappers.SchoolMapper;
import com.example.demo.restImpl.dto.SchoolDto;
import com.example.demo.restImpl.dto.SchoolResponseDto;
import com.example.demo.restImpl.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private SchoolRepository repository;
    private SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository repository, SchoolMapper schoolMapper) {
        this.repository = repository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolResponseDto createSchool(SchoolDto dto){
        var school = schoolMapper.toSchool(dto);
        var savedSchool = repository.save(school);
        return schoolMapper.schoolResponseDto(savedSchool);
    }

    public List<SchoolResponseDto> findAll(){
        return repository.findAll()
                .stream()
                .map(schoolMapper::schoolResponseDto)
                .collect(Collectors.toList());
    }
}

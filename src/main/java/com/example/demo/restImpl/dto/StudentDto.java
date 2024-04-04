package com.example.demo.restImpl.dto;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}

package com.example.demo.restImpl;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}

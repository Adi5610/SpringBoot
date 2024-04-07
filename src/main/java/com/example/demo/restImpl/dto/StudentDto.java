package com.example.demo.restImpl.dto;

import jakarta.validation.constraints.NotEmpty;


public record StudentDto(
        @NotEmpty
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}

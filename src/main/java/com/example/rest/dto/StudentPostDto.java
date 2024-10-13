package com.example.rest.dto;

import jakarta.validation.constraints.NotEmpty;

public record StudentPostDto(
    @NotEmpty
    String firstname,
    @NotEmpty(message = "LastName should not be empty")
    String lastname,
    String email,
    int schoolId) {

}

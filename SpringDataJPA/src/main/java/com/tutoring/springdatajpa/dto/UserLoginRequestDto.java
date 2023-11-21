package com.tutoring.springdatajpa.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UserLoginRequestDto {

    @Email
    @NotBlank
    private final String username;

    @NotBlank
    private final String password;

}
package com.tutoring.springdatajpa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class OtpVerificationRequestDto {
    private final String username;
    private final Integer OTP;
}
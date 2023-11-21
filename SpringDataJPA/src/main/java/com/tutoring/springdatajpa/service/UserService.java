package com.tutoring.springdatajpa.service;

import com.tutoring.springdatajpa.dto.OtpVerificationRequestDto;
import com.tutoring.springdatajpa.dto.UserLoginRequestDto;
import com.tutoring.springdatajpa.dto.UserLoginSuccessDto;
import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.UserRepository;
//import com.google.common.cache.LoadingCache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    //private final LoadingCache<String, Integer> oneTimePasswordCache;
    private final HashMap<String, Integer> otpCache;
    private final EmailService emailService;
    public ResponseEntity<?> login(final UserLoginRequestDto userLoginRequestDto) {
        final User user = userRepository.findByUsername(userLoginRequestDto.getUsername()).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid login credentials"));

        if(!passwordEncoder.matches(userLoginRequestDto.getPassword(), user.getPassword()))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid login credentials");

        sendOtp(user, "2FA: Request to log in to your account");
        return ResponseEntity.ok(getOtpSendMessage());
    }

    public ResponseEntity<UserLoginSuccessDto> verifyOtp(final OtpVerificationRequestDto otpVerificationRequestDto) {
        User user = userRepository.findByUsername(otpVerificationRequestDto.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username"));

        Integer storedOTP = otpCache.get(user.getUsername());
        if (storedOTP == null){
            log.error("Failed to fetch from OTP cache");
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
        }

        if(storedOTP.equals(otpVerificationRequestDto.getOtp()))
            return ResponseEntity.ok().build();

        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    private void sendOtp(final User user, final String subject) {
        final var otp = new Random().ints(1, 100000, 999999).sum();
        otpCache.put(user.getUsername(), otp);

        CompletableFuture.supplyAsync(() -> {
           emailService.sendEmail(user.getUsername(), subject, "OTP: " + otp);
           return HttpStatus.OK;
        });
    }

    private Map<String, String> getOtpSendMessage() {
        final var response = new HashMap<String, String>();
        response.put("message",
                "OTP sent successfully to your email. verify it using /verify-otp endpoint.");
        return response;
    }
}

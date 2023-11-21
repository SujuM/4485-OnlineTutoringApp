package com.tutoring.springdatajpa.http.controllers;

import com.tutoring.springdatajpa.dto.OtpVerificationRequestDto;
import com.tutoring.springdatajpa.dto.UserLoginRequestDto;
import com.tutoring.springdatajpa.dto.UserLoginSuccessDto;
import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.UserRepository;
import com.tutoring.springdatajpa.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


import org.springframework.http.MediaType;

@RestController
public class AuthController {
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/debug/users")
    public List<User> index(Principal principal) {
        List<User> result = new ArrayList<User>();
        this.userRepository.findAll().forEach(result::add);
        return result;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request)
    {
        User user = new User(request.email, passwordEncoder.encode(request.password));

        this.userRepository.save(user);

        return new ResponseEntity<>("registration success", HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<User> index2() {
        List<User> result = new ArrayList<User>();
        this.userRepository.findAll().forEach(result::add);
        return result;
    }

    @PostMapping(value="/login", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> userLoginHandler(
            @RequestBody(required=true) final UserLoginRequestDto userLoginRequestDto) {
        return userService.login(userLoginRequestDto);
    }

    @PostMapping(value = "/verify-otp", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<UserLoginSuccessDto> otpVerificationHandler(
            @RequestBody(required = true) final OtpVerificationRequestDto otpVerificationRequestDto) {
        return userService.verifyOtp(otpVerificationRequestDto);
    }

    public boolean checkPassword(String password)
    {
        return(password.matches("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$"));
    }

}

class RegisterRequest {
    @Email
    public String email;
    @NotBlank
    public String password;
}
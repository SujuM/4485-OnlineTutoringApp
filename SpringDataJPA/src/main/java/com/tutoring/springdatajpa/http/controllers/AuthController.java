package com.tutoring.springdatajpa.http.controllers;

import com.tutoring.springdatajpa.dto.OtpVerificationRequestDto;
import com.tutoring.springdatajpa.dto.UserRegistrationRequestDto;
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

    /*
    @PostMapping("/auth/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request)
    {

        if(checkPassword(request.password))
        {
            User user = new User(request.firstName, request.lastName, request.email, passwordEncoder.encode(request.password));
            this.userRepository.save(user);
            return new ResponseEntity<>("registration success", HttpStatus.OK);
        }
        return new ResponseEntity<>("registration unsuccessful", HttpStatus.NOT_ACCEPTABLE);
    }
     */

    @PostMapping(value="/auth/register", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> registrationHandler(
            @RequestBody(required=true) final UserRegistrationRequestDto userRegistrationRequestDto) {
        return userService.register(userRegistrationRequestDto);
    }

    @PostMapping("/{email}/auth/change-password")
    public ResponseEntity<String> register(@PathVariable String email, @RequestBody ChangePassRequest request)
    {
        User user = userRepository.findByUsernameAndPassword(email,request.currentPassword);
        if(passwordEncoder.encode(request.currentPassword).equals(user.getPassword()))
        {
            user.setPassword(passwordEncoder.encode(request.newPassword));
            this.userRepository.save(user);
            return new ResponseEntity<>("password change was a success", HttpStatus.OK);
        }
        return new ResponseEntity<>("password change was unsuccessful", HttpStatus.NOT_ACCEPTABLE);
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
    public ResponseEntity<UserLoginSuccessDto> otpLoginHandler(
            @RequestBody(required = true) final OtpVerificationRequestDto otpVerificationRequestDto) {
        return userService.verifyOtp(otpVerificationRequestDto);
    }

    @PostMapping(value="/verify-email", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> userVerificationHandler(
            @RequestBody(required=true) final UserLoginRequestDto userLoginRequestDto) {
        return userService.verifyEmail(userLoginRequestDto);
    }

    public boolean checkPassword(String password)
    {
        return(password.matches("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$"));
    }
}

class RegisterRequest {
    @NotBlank
    public String firstName;
    @NotBlank
    public String lastName;
    @Email
    public String email;
    @NotBlank
    public String password;
}

class ChangePassRequest {
    @NotBlank
    public String currentPassword;
    @NotBlank
    public String newPassword;
}
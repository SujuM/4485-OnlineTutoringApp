package com.tutoring.springdatajpa.http.controllers;

import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthController {
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
}

class RegisterRequest {
    @Email
    public String email;
    @NotBlank
    public String password;
}
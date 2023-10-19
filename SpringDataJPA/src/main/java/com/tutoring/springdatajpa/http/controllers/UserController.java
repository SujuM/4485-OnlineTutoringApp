package com.tutoring.springdatajpa.http.controllers;

import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {

        this.repository = repository;
    }

    @GetMapping("/users")
    public List<User> index() {
        List<User> result = new ArrayList<User>();
         this.repository.findAll().forEach(result::add);
         return result;
    }

    @GetMapping("/users/{id}")
    public Optional<User> show(@PathVariable long id) {
        return this.repository.findById(id);
    }

}

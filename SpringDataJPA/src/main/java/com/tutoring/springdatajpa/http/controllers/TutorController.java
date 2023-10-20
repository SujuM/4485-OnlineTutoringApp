package com.tutoring.springdatajpa.http.controllers;

import com.tutoring.springdatajpa.entities.Tutor;
import com.tutoring.springdatajpa.repositories.TutorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TutorController {

    private final TutorRepository repository;

    public TutorController(TutorRepository repository) {

        this.repository = repository;
    }

    @GetMapping("/tutors")
    public List<Tutor> index() {
        List<Tutor> result = new ArrayList<Tutor>();
         this.repository.findAll().forEach(result::add);
         return result;
    }

    @GetMapping("/tutors/{id}")
    public Optional<Tutor> show(@PathVariable long id) {
        return this.repository.findById(id);
    }

}

package com.tutoring.springdatajpa.http.controllers;

//import com.tutoring.springdatajpa.SearchTutorService;
import com.tutoring.springdatajpa.SearchTutorService;
import com.tutoring.springdatajpa.entities.Tutor;
import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.TutorRepository;
import com.tutoring.springdatajpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TutorController {

    private final TutorRepository repository;
    private final UserRepository userRepository;

    private final SearchTutorService searchTutorService;

    public TutorController(TutorRepository repository, UserRepository userRepository,SearchTutorService searchTutorService){ //) {

        this.repository = repository;
        this.userRepository = userRepository;
        this.searchTutorService = searchTutorService;
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

    @GetMapping("/search")
    public List <Tutor> searchTutorsBySubject(@RequestParam("name") String name)
    {
        return searchTutorService.searchForTutorsBySubjectNames(name);
    }



}

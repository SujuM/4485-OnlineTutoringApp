package com.tutoring.springdatajpa.http.controllers;

//import com.tutoring.springdatajpa.SearchTutorService;
import com.tutoring.springdatajpa.SearchTutorService;
import com.tutoring.springdatajpa.entities.Student;
import com.tutoring.springdatajpa.entities.Tutor;
import com.tutoring.springdatajpa.repositories.StudentRepository;
import com.tutoring.springdatajpa.repositories.TutorRepository;
import com.tutoring.springdatajpa.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentRepository repository;
    private final UserRepository userRepository;

    public StudentController(StudentRepository repository, UserRepository userRepository){ //) {

        this.repository = repository;
        this.userRepository = userRepository;
    }

    @GetMapping("/students")
    public List<Student> showAllStudents() {
        List<Student> result = new ArrayList<Student>();
        this.repository.findAll().forEach(result::add);
         return result;
    }

    @GetMapping("/students/{id}")
    public Optional<Student> showStudent(@PathVariable long id) {
        return this.repository.findById(id);
    }

}

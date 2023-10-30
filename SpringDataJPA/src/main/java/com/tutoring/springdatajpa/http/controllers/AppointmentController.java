package com.tutoring.springdatajpa.http.controllers;

import com.tutoring.springdatajpa.entities.Appointment;
import com.tutoring.springdatajpa.repositories.AppointmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AppointmentController {

    private final AppointmentRepository repository;

    public AppointmentController(AppointmentRepository repository) {

        this.repository = repository;
    }

    @GetMapping("/appointments")
    public List<Appointment> index() {
        List<Appointment> result = new ArrayList<Appointment>();
         this.repository.findAll().forEach(result::add);
         return result;
    }

    @GetMapping("/appointments/{id}")
    public Optional<Appointment> show(@PathVariable long id) {
        return this.repository.findById(id);
    }

}

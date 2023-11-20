package com.tutoring.springdatajpa.http.controllers;

import com.tutoring.springdatajpa.entities.Appointment;
import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Annotation
@RestController
public class AppointmentController {

    @Autowired
    private final AppointmentRepository repository;

    public AppointmentController(AppointmentRepository repository) {

        this.repository = repository;
    }

    // Show the list of user's appointments
    @GetMapping("/appointments")
    public List<Appointment> getAppointments() {
        List<Appointment> result = new ArrayList<Appointment>();
         this.repository.findAll().forEach(result::add);
         return result;
    }

    @GetMapping("/appointment/{id}")
    public Optional<Appointment> getAppointment(@PathVariable long id) {
        return this.repository.findById(id);
    }

    @DeleteMapping("/appointment/{id}")
    public void deleteAppointment(@PathVariable("id") long id) {
        this.repository.deleteById(id);
    }
    @PostMapping("/appointment")
    public void addAppointment(@RequestBody Appointment appointment) {
        this.repository.save(appointment);
    }

    @PostMapping("/new")
    public String bookAppointment(@RequestParam("workId") int workId, @RequestParam("providerId") int providerId, @RequestParam("start") String start, @AuthenticationPrincipal User currentUser) {
//        appointmentService.createNewAppointment(currentUser.getId(), LocalDateTime.parse(start));
        return "redirect:/appointments/all";
    }

    @PutMapping("/appointment")
    public void updateAppointment(@RequestBody Appointment appointment) {
    }
}

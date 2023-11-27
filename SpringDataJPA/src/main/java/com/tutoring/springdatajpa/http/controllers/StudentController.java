package com.tutoring.springdatajpa.http.controllers;

//import com.tutoring.springdatajpa.SearchTutorService;
import com.tutoring.springdatajpa.entities.Appointment;
import com.tutoring.springdatajpa.entities.Student;
import com.tutoring.springdatajpa.repositories.AppointmentRepository;
import com.tutoring.springdatajpa.repositories.StudentRepository;
import com.tutoring.springdatajpa.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentRepository repository;
    private final UserRepository userRepository;

    private final AppointmentRepository appointmentRepository;


    public StudentController(StudentRepository repository, UserRepository userRepository, AppointmentRepository appointmentRepository){ //) {

        this.repository = repository;
        this.userRepository = userRepository;
        this.appointmentRepository = appointmentRepository;
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

    @PutMapping("/students/{id}/appointments/{app_id}")
    public Appointment updateAppointmentStatus(@PathVariable("id") long id, @PathVariable("app_id") long appointmentID) {
        Appointment appointment = appointmentRepository.findById(appointmentID).get();
        appointment.setStatus(Appointment.AppointmentStatus.CONFIRMED);
        appointmentRepository.save(appointment);
        return appointment;
    }

}

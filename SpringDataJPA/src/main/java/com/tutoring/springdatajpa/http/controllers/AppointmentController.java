package com.tutoring.springdatajpa.http.controllers;

import com.tutoring.springdatajpa.entities.Appointment;
import com.tutoring.springdatajpa.entities.Student;
import com.tutoring.springdatajpa.entities.Tutor;
import com.tutoring.springdatajpa.repositories.AppointmentRepository;
import com.tutoring.springdatajpa.repositories.StudentRepository;
import com.tutoring.springdatajpa.repositories.TutorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class AppointmentController {

    private final AppointmentRepository repository;

    private final StudentRepository studentRepository;

    private final TutorRepository tutorRepository;

    public AppointmentController(AppointmentRepository repository, StudentRepository studentRepository, TutorRepository tutorRepository) {

        this.repository = repository;
        this.studentRepository = studentRepository;
        this.tutorRepository = tutorRepository;
    }

    @PostMapping("/appointments")
    public Appointment store(@RequestBody StoreAppointmentRequest request) {
        Tutor tutor = tutorRepository.findById(request.tutorID).get();
        Appointment appointment = new Appointment(tutor, request.startTime, request.endTime);
        repository.save(appointment);
        return appointment;
    }

    @PutMapping("/appointments/{id}")
    public Appointment update(@RequestBody UpdateAppointmentRequest request, @PathVariable long id) {
        Appointment appointment = repository.findById(id).get();
        Student student = studentRepository.findById(request.studentID).get();

        appointment.setStudent(student);
        repository.save(appointment);

        return appointment;
    }

    @GetMapping("/appointments")
    public List<Appointment> index() {
        List<Appointment> result = new ArrayList<Appointment>();
         this.repository.findAll().forEach(result::add);
         return result;
    }

    @GetMapping("/students/{id}/appointments")
    public List<Appointment> studentIndex(@PathVariable long id) {
        Student student = studentRepository.findById(id).get();
        return student.getAppointments();
    }

    @GetMapping("/tutors/{id}/appointments")
    public List<Appointment> tutorIndex(@PathVariable long id) {
        Tutor tutor = tutorRepository.findById(id).get();
        return tutor.getAppointments();
    }

    @GetMapping("/appointments/{id}")
    public Optional<Appointment> show(@PathVariable long id) {
        return this.repository.findById(id);
    }

    @DeleteMapping("/appointments/{id}")
    public void delete(@PathVariable("id") long id) {
        this.repository.deleteById(id);
    }

    public static class StoreAppointmentRequest {
        public Long tutorID;
        public Date startTime;
        public Date endTime;
    }

    public static class UpdateAppointmentRequest {
        public Long studentID;
    }

}

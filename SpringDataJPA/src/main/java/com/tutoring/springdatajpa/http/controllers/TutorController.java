package com.tutoring.springdatajpa.http.controllers;

//import com.tutoring.springdatajpa.SearchTutorService;
import com.tutoring.springdatajpa.SearchTutorService;
import com.tutoring.springdatajpa.entities.Appointment;
import com.tutoring.springdatajpa.entities.Tutor;
import com.tutoring.springdatajpa.repositories.AppointmentRepository;
import com.tutoring.springdatajpa.repositories.TutorRepository;
import com.tutoring.springdatajpa.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TutorController {

    private final TutorRepository repository;
    private final UserRepository userRepository;
    private final AppointmentRepository appointmentRepository;

    private final SearchTutorService searchTutorService;

    public TutorController(TutorRepository repository, UserRepository userRepository, AppointmentRepository appointmentRepository, SearchTutorService searchTutorService){ //) {

        this.repository = repository;
        this.userRepository = userRepository;
        this.appointmentRepository = appointmentRepository;
        this.searchTutorService = searchTutorService;
    }

    @GetMapping("/tutors")
    public List<Tutor> showAllTutors() {
        List<Tutor> result = new ArrayList<Tutor>();
         this.repository.findAll().forEach(result::add);
         return result;
    }

    @GetMapping("/tutors/{id}")
    public Optional<Tutor> showTutor(@PathVariable long id) {
        return this.repository.findById(id);
    }

    @PutMapping("/tutors/{id}/appointments/{app_id}")
    public Appointment updateAppointmentStatus(@PathVariable("id") long id, @PathVariable("app_id") long appointmentID) {
        Appointment appointment = appointmentRepository.findById(appointmentID).get();
        appointment.setStatus(Appointment.AppointmentStatus.FINISHED);
        appointmentRepository.save(appointment);
        return appointment;
    }

//    @GetMapping("/search")
//    public List <Tutor> searchTutorsBySubject(@RequestParam("name") String name)
//    {
//        return searchTutorService.searchForTutorsBySubjectNames(name);
//    }



}

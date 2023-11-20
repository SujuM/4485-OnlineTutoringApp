package com.tutoring.springdatajpa;

import com.tutoring.springdatajpa.entities.Appointment;
import com.tutoring.springdatajpa.repositories.AppointmentRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;
    private AppUserDetailsService userService;

    public AppointmentService(AppointmentRepository appointmentRepository, AppUserDetailsService userService) {
        this.appointmentRepository = appointmentRepository;
        this.userService = userService;
    }

    public void createNewAppointment(int tutorID, LocalDateTime start, LocalDateTime end) {
            Appointment appointment = new Appointment(tutorID, start, end);
            appointmentRepository.save(appointment);
    }

//    @PreAuthorize("#StudentId == principal.id")
    public List<Appointment> getAppointmentByStudentId(int StudentId) {
        return appointmentRepository.findByStudentID(StudentId);
    }

//    @PreAuthorize("#tutorId == principal.id")
    public List<Appointment> getAppointmentByTutorId(int tutorId) {
        return appointmentRepository.findByTutorID(tutorId);
    }



}

package com.tutoring.springdatajpa.entities;

import jakarta.persistence.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "students")
public class Student extends User{
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private List<Appointment> appointments;
    public Student() {
    }

    public Student(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment)
    {
        appointments.add(appointment);
    }
}

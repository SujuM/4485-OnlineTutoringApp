package com.tutoring.springdatajpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "tutor_id")
    private int tutor_id;
    @Column(name = "student_id")
    private int student_id;

    @Column(name = "start_time")
    private Date start_time;

    @Column(name = "end_time")
    private Date end_time;
    @Column(name = "book_time")
    private Date book_time;
    @Column(name = "canceled")
    private boolean canceled;


    public Appointment() {}

    public Appointment(int tutor_id, int student_id, Date start_time, Date end_time, Date book_time) {
        this.tutor_id = tutor_id;
        this.student_id = student_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.book_time = book_time;
        this.canceled = false;
    }

    public int getId() {
        return id;
    }
    public void cancel() {
        this.canceled = true;
    }
}



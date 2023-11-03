package com.tutoring.springdatajpa.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "tutor_id")
    private int tutorID;

    @Column(name = "student_id")
    private int studentID;


    public Appointment() {}

    public Appointment(int tutorID, int studentID, Date start_time, Date end_time, Date book_time) {
        this.tutorID = tutorID;
        this.studentID = studentID;
    }

    public int getId() {
        return id;
    }

    public int getTutorID() {
        return tutorID;
    }

    public void setTutorID(User tutor) {
        this.tutorID = tutor.getId();
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(User student) {
        this.studentID = student.getId();
    }
}



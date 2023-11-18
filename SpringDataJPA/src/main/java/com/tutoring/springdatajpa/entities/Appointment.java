package com.tutoring.springdatajpa.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "appointments")
public class Appointment implements Comparable<Appointment> {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "tutor_id")
    private int tutorID;

    @Column(name = "student_id")
    private int studentID;

    @Column(name = "start")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime start;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "end")
    private LocalDateTime end;

    private Duration duration;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AppointmentStatus status;


    public Appointment() {}

    public Appointment(int tutorID, LocalDateTime start, LocalDateTime end) {
        this.tutorID = tutorID;
        this.start = start;
        this.end = end;

        setStatus(AppointmentStatus.AVAILABLE);
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

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = Duration.between(getStart(), getEnd());
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    @Override
    public int compareTo(Appointment o) {
        return this.getStart().compareTo(o.getStart());
    }
}



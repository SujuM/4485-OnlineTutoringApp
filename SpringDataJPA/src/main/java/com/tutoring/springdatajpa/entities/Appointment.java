package com.tutoring.springdatajpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @JsonIgnore
    @ManyToOne(optional=false, cascade = CascadeType.MERGE)
    private Tutor tutor;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private Student student;


    @Column
    private String tutorFirstName;

    @Column
    private String tutorLastName;

    @Column
    private String studentFirstName;

    @Column
    private String studentLastName;


    @Column
    private Date startTime;

    @Column
    private Date endTime;

    @Enumerated(EnumType.STRING)
    @Column
    private AppointmentStatus status;

    public enum AppointmentStatus {
        AVAILABLE,
        SCHEDULED,
        CONFIRMED,
        FINISHED,
        CANCELED
    }


    public Appointment() {}

    public Appointment(Tutor tutor, Date start_time, Date end_time) {
        this.tutor = tutor;
        tutor.addAppointment(this);
        this.startTime = start_time;
        this.endTime = end_time;

        setStatus(AppointmentStatus.AVAILABLE);
    }


    public int getId() {
        return id;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setStudent(Student student) {
        this.student = student;
        this.setStatus(AppointmentStatus.SCHEDULED);
        student.addAppointment(this);
    }

    public Student getStudent() {
        return student;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }


    public String getTutorFirstName() {
        return tutorFirstName;
    }

    public void setTutorFirstName(String tutorFirstName) {
        this.tutorFirstName = tutorFirstName;
    }

    public String getTutorLastName() {
        return tutorLastName;
    }

    public void setTutorLastName(String tutorLastName) {
        this.tutorLastName = tutorLastName;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }
}





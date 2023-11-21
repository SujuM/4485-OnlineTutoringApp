package com.tutoring.springdatajpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "tutors")
public class Tutor extends User{
//    @OneToMany
//    private List<String> subjectList;
    private String subjectName;
    @Column
    private String aboutMe;
    @ElementCollection
    private List<String> availableHours;
    @ElementCollection
    private List<String> tutorSubjectList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tutor")
    private List<Appointment> appointments;
//    @Column(nullable = false)
//    private String username;
//    @Column
//    private Boolean isTutor;
//    public String getUsername() {
//        return username;
//    }
//    public Boolean isTutor() {return false;}
    public Tutor() {

    }
    public Tutor(String aboutMe, List<String> tutorSubjectList, String username, String password, Boolean isTutor, Boolean isCriminal)
    {
        super(username, password, isTutor, isCriminal);
        this.aboutMe = aboutMe;
        this.tutorSubjectList = tutorSubjectList;

    }


//    public void setUsername(String username) {
//        this.username = username;
//    }

    public String getAboutMe(){return aboutMe;}
    public List<String> getAvailableHours(){return availableHours;}
    public void setSubjectList(List <String> tutorSubjectList){this.tutorSubjectList=tutorSubjectList;}
    public List<String> getSubjectList(){return tutorSubjectList;}
    public void addSubjectToSubjectList(String subject)
    {
        if(tutorSubjectList == null)
        {
            tutorSubjectList = new ArrayList<>();
        }
        if(tutorSubjectList.contains(subject) == false)
        {
            tutorSubjectList.add(subject);
        }
    }
    public void removeSubjectToSubjectList(String subject)
    {
        if(tutorSubjectList.contains(subject) == true)
        {
            tutorSubjectList.remove(subject);
        }
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment)
    {
        appointments.add(appointment);
    }

    //    @Column(name = "email")
//    private String email;
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "totalhours")
//    private int totalhours;
//
//    @Column(name = "info")
//    private int info;
//
//    public Tutor() {
//
//    }
//
//    public Tutor(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public int getTotalHours() {
//        return totalhours;
//    }
//    public int getInfo() {
//        return info;
//    }
}

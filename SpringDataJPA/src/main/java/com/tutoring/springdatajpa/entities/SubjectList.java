package com.tutoring.springdatajpa.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "subjectlist")
public class SubjectList
{

    @Id
    @GeneratedValue
    @Column(name = "subjectId")
    private int subjectId;

    @Column(name = "subjectName")
    private String subjectName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;
    @Column(name = "tutorId")
    private int tutorId;

    public SubjectList() {

    }

    public void setId(int id) {
        this.subjectId = id;
    }

    public int getSubjectId() {
        return subjectId;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setFirstName() {
        this.firstName = firstName;
    }
    public void setLastName() {this.lastName = lastName;}
    public int getTutorId() {
        return tutorId;
    }
    public SubjectList(int subjectId, String subjectName, String firstName, String lastName, int tutorId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.tutorId = tutorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}

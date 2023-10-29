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
    private Long subjectid;

    @Column(name = "subjectName")
    private String subjectName;

    @Column(name = "subjectTutor")
    private String subjectTutor;

    public SubjectList() {

    }

    public void setId(Long id) {
        this.subjectid = id;
    }

    public Long getId() {
        return subjectid;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public SubjectList(Long subjectid, String subjectName) {
        this.subjectid = subjectid;
        this.subjectName = subjectName;
    }
    public String getSubjectTutor() {
        return subjectTutor;
    }

}

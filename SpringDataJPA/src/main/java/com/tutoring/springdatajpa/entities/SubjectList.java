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

    @Column(name = "tutorName")
    private String tutorName;
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

    public String getSubjectName() {
        return subjectName;
    }
    public String getTutorName() {
        return subjectName;
    }
    public int getTutorId() {
        return tutorId;
    }
    public SubjectList(int subjectId, String subjectName, String tutorName, int tutorId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.tutorId = tutorId;
        this.tutorName = tutorName;
    }

}

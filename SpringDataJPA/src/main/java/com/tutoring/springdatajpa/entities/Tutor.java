package com.tutoring.springdatajpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "tutors")
public class Tutor {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "totalhours")
    private int totalhours;

    @Column(name = "info")
    private int info;

    public Tutor() {

    }

    public Tutor(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getTotalHours() {
        return totalhours;
    }
    public int getInfo() {
        return info;
    }
}

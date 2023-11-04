package com.tutoring.springdatajpa.http.controllers;

import com.tutoring.springdatajpa.entities.Appointment;
import com.tutoring.springdatajpa.entities.SubjectList;
import com.tutoring.springdatajpa.repositories.AppointmentRepository;
import com.tutoring.springdatajpa.repositories.SubjectListRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
public class SubjectListController
{

        private final SubjectListRepository repository;

        public SubjectListController(SubjectListRepository repository) {

            this.repository = repository;
        }

        @GetMapping("/SubjectList")
        public List<SubjectList> index() {
            List<SubjectList> result = new ArrayList<SubjectList>();
            this.repository.findAll().forEach(result::add);
            return result;
        }

        @GetMapping("/SubjectList/{subjectId}")
        public Optional<SubjectList> show(@PathVariable long subjectId) {
            return this.repository.findById(subjectId);
        }

}


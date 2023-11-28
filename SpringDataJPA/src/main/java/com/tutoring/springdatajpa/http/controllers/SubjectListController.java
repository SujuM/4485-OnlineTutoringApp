package com.tutoring.springdatajpa.http.controllers;

import com.tutoring.springdatajpa.SearchTutorService;
import com.tutoring.springdatajpa.entities.SubjectList;
import com.tutoring.springdatajpa.entities.Tutor;
import com.tutoring.springdatajpa.repositories.SubjectListRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
public class SubjectListController
{

        private final SubjectListRepository repository;
        private final SearchTutorService searchTutorService;
//
        public SubjectListController(SubjectListRepository repository, SearchTutorService searchTutorService){ //) {
            this.searchTutorService = searchTutorService;
            this.repository = repository;
        }

//        @GetMapping("/searchTutor")
//        public List<Tutor> searchTutorsBySubject(@RequestParam String subject)
//        {
//            return searchTutorService.searchForTutorsBySubjectNames(subject);
//        }

//        @PostMapping("/{tutorName}/addSubject")
//        public void addSubjectToSubjectList(@PathVariable String tutorName, @RequestParam String subject)
//        {
//            searchTutorService.addSubjectToSubjectList(tutorName,subject);
//        }

//        @PostMapping("/{tutorName}/removeSubject")
//        public void removeSubjectToSubjectList(@PathVariable String tutorName, @RequestParam String subject)
//        {
//            searchTutorService.removeSubjectToSubjectList(tutorName, subject);
//        }

//        @GetMapping("/{firstName}/{lastName}/subjects")
//        public List<String> findSubjectsByFirstAndLastName(@PathVariable String firstName, @PathVariable String lastName)
//        {
//            return searchTutorService.searchForSubjectsByFirstAndLastName(firstName, lastName);
//        }

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


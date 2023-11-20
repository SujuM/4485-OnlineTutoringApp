package com.tutoring.springdatajpa;

import com.tutoring.springdatajpa.entities.SubjectList;
import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.SubjectListRepository;
import com.tutoring.springdatajpa.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@Service
public class SubjectListService
{
    private final SubjectListRepository subjectListRespository;


    public SubjectListService (SubjectListRepository subjectListRepository) {
        this.subjectListRespository = subjectListRepository;
    }
    public SubjectList getTutorsbySubjectName(@PathVariable String subject) throws SubjectNameNotFoundException {
        Optional<SubjectList> tutors = this.subjectListRespository.findTutorsBySubjectName(subject);

        if (tutors.isEmpty()) {
            throw new SubjectNameNotFoundException("tutors not found with " + subject);
        }

        return tutors.get();
    }
    public SubjectList getSubjectsbyTutorName(String tutorName) throws TutorNameNotFoundException {
        Optional<SubjectList> tutors = this.subjectListRespository.findSubjectByTutorName(tutorName);

        if (tutors.isEmpty()) {
            throw new TutorNameNotFoundException("subjects not found for" + tutorName);
        }

        return tutors.get();
    }
}

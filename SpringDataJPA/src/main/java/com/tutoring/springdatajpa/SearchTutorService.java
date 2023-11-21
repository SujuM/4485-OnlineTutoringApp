package com.tutoring.springdatajpa;

import com.tutoring.springdatajpa.entities.SubjectList;
import com.tutoring.springdatajpa.entities.Tutor;
import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.TutorRepository;
import com.tutoring.springdatajpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class  SearchTutorService
{
    private final TutorRepository tutorRepository;

    public SearchTutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public List<Tutor> searchForTutorsBySubjectNames(String subject)
    {
        return tutorRepository.findByTutorSubjectListContaining(subject);
    }
    public List<String> searchForSubjectsByTutorName(String username)
    {
        Tutor tutor = tutorRepository.findByUsernameAndIsTutor(username, true);
        if(tutor != null && tutor.getSubjectList() != null )
        {
            return tutor.getSubjectList();
        }
        else
        {
            System.out.println("Unable to find tutor.");
            return Collections.emptyList();
        }
    }
    //
    public void addSubjectToSubjectList(String username, String subject)
    {
        Tutor tutor = tutorRepository.findByUsernameAndIsTutor(username, true);
        if(tutor != null ) {
            if (tutor.getSubjectList() != null) {
                tutor.setSubjectList(new ArrayList<>());
            }
            tutor.addSubjectToSubjectList(subject);
            tutorRepository.save(tutor);
            System.out.println(subject + " was added to" + username + "'s subject list.");
        }
        else{System.out.println("Unable to add subject because tutor does not exist.");}

    }
    public void removeSubjectToSubjectList(String username, String subject)
    {
        Tutor tutor = tutorRepository.findByUsernameAndIsTutor(username, true);
        if(tutor != null ) {
            tutor.removeSubjectToSubjectList(subject);
            tutorRepository.save(tutor);
            System.out.println(subject + " was removed from" + username + "'s subject list.");
        }
        else{System.out.println("Unable to remove subject because tutor does not exist.");}

    }

}

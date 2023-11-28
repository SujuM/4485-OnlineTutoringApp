package com.tutoring.springdatajpa;

import com.tutoring.springdatajpa.entities.Tutor;
import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.TutorRepository;
import com.tutoring.springdatajpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesService
{
    private final UserRepository userRepository;
    private final TutorRepository tutorRepository;

    public FavoritesService(UserRepository userRepository, TutorRepository tutorRepository)
    {
        this.userRepository = userRepository;
        this.tutorRepository = tutorRepository;
    }

    public List<Tutor> getFavoritesList(int studentId)
    {
        User student = userRepository.findById(studentId);
        if(student != null)
        {
            return student.getFavoriteTutorList();
        }
        else
        {
            System.out.println("Unable to find student");
            return null;
        }
    }

    public void addTutorToFavoriteList(int studentId, int tutorId)
    {
        User student = userRepository.findById(studentId);
        Tutor tutor = tutorRepository.findById(tutorId);
        if(student != null && tutor != null)
        {
            student.addTutorToFavorites(tutor);
            userRepository.save(student);
            System.out.println("Tutor was added successfully to favorites list");
        }
        else {
            System.out.println("Unable to add tutor to favorites list");
        }

    }

    public void removeTutorFromFavoriteList(int studentId, int tutorId)
    {
        User student = userRepository.findById(studentId);
        Tutor tutor = tutorRepository.findById(tutorId);
        if(student != null && tutor != null)
        {
            student.removeTutorFromFavorites(tutor);
            userRepository.save(student);
            System.out.println("Tutor was removed successfully to favorites list");
        }
        else {
            System.out.println("Unable to remove tutor to favorites list");
        }

    }
}

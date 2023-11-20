package com.tutoring.springdatajpa;

import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesService
{
    private final UserRepository userRepository;

    public FavoritesService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<User> getFavoritesList(String studentUsername)
    {
        User student = userRepository.findByUsernameAndIsTutor(studentUsername, false);
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

    public void addTutorToFavoriteList(String studentUsername, String tutorUsername)
    {
        User student = userRepository.findByUsernameAndIsTutor(studentUsername, false);
        User tutor = userRepository.findByUsernameAndIsTutor(tutorUsername, true);
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

    public void removeTutorFromFavoriteList(String studentUsername, String tutorUsername)
    {
        User student = userRepository.findByUsernameAndIsTutor(studentUsername, false);
        User tutor = userRepository.findByUsernameAndIsTutor(tutorUsername, true);
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

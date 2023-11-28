package com.tutoring.springdatajpa.http.controllers;

import com.tutoring.springdatajpa.FavoritesService;
import com.tutoring.springdatajpa.entities.Tutor;
import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.UserRepository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class FavoritesController
{
    private final FavoritesService favoritesService;

    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }

    @PostMapping("/users/{studentId}/favorites/add")
    public ResponseEntity<String> addTutorToFavoritesList(@PathVariable int studentId, @RequestParam int tutorId)
    {
        try
        {
            favoritesService.addTutorToFavoriteList(studentId,tutorId);
            return ResponseEntity.ok("Tutor was added to favorites list");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to add tutor");
        }
    }

    @DeleteMapping("/users/{studentId}/favorites/remove")
    public ResponseEntity<String> removeTutorToFavoritesList(@PathVariable int studentId, @RequestParam int tutorId)
    {
        try
        {
            favoritesService.removeTutorFromFavoriteList(studentId,tutorId);
            return ResponseEntity.ok("Tutor was removed from favorites list");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to remove tutor");
        }
    }

    @GetMapping("/users/{studentId}/favorites")
    public List<Tutor> getFavoritesList(@PathVariable int studentId)
    {
        return favoritesService.getFavoritesList(studentId);
    }
}
//class TutorRequest {
//    @NotBlank
//    public String firstName;
//    @NotBlank
//    public String lastName;
//    @Email
//    public String email;
//    @NotBlank
//    public String password;
//}

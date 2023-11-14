package com.tutoring.springdatajpa.http.controllers;

import com.tutoring.springdatajpa.FavoritesService;
import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class FavoritesController
{
    private final FavoritesService favoritesService;

    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }

    @PostMapping("/{studentUsername}/add/{tutorUsername}")
    public String addTutorToFavoritesList(@PathVariable String studentUsername, @PathVariable String tutorUsername)
    {
        favoritesService.addTutorToFavoriteList(studentUsername,tutorUsername);
        return "Tutor was added to favorites list";
    }

    @PostMapping("/{studentUsername}/remove/{tutorUsername}")
    public String removeTutorToFavoritesList(@PathVariable String studentUsername, @PathVariable String tutorUsername)
    {
        favoritesService.removeTutorFromFavoriteList(studentUsername,tutorUsername);
        return "Tutor was removed to favorites list";
    }

    @GetMapping
    public List<User> getFavoritesList(@PathVariable String studentUsername)
    {
        return favoritesService.getFavoritesList(studentUsername);
    }
}

package com.tutoring.springdatajpa.repositories;


import com.tutoring.springdatajpa.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    //
}


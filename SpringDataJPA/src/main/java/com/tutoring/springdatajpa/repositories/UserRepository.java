package com.tutoring.springdatajpa.repositories;

import com.tutoring.springdatajpa.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Use this interface to perform CRUD op in our app code.
public interface UserRepository extends CrudRepository<User, Long> {
//    List<Employee> findEmployeeByLastNameContaining(String str);

    List<User> findUsersByIdContaining(String str);
}

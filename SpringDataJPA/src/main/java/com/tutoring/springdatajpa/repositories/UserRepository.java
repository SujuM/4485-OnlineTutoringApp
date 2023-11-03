package com.tutoring.springdatajpa.repositories;

import com.tutoring.springdatajpa.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// Use this interface to perform CRUD op in our app code.
// to tell Spring Data JPA about the domain type (User) and ID type (Long) to work with
public interface UserRepository extends CrudRepository<User, Long> {
//    List<Employee> findEmployeeByLastNameContaining(String str);

    Optional<User> findByUsername(String username);

}

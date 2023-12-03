package com.tutoring.springdatajpa.repositories;

import com.tutoring.springdatajpa.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Use this interface to perform CRUD op in our app code.
public interface UserRepository extends CrudRepository<User, Long> {
//    List<Employee> findEmployeeByLastNameContaining(String str);

    Optional<User> findByUsername(String username);
    //Optional<User> findByUsernameAndIsTutor(String username, boolean isTutor);
    User findByUsernameAndIsTutor(String username, boolean isTutor);

    User findByUsernameAndPassword(String username, String password);
    User findById(Integer id);

    boolean existsByUsername(String username);

}

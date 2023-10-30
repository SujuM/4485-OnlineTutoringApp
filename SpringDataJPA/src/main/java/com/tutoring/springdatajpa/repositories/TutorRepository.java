package com.tutoring.springdatajpa.repositories;

import com.tutoring.springdatajpa.entities.Tutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Use this interface to perform CRUD op in our app code.
public interface TutorRepository extends CrudRepository<Tutor, Long> {
//    List<Employee> findEmployeeByLastNameContaining(String str);

    List<Tutor> findUsersByIdContaining(String str);
}

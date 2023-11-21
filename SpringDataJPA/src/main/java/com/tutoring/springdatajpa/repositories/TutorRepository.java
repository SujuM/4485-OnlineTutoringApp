package com.tutoring.springdatajpa.repositories;

import com.tutoring.springdatajpa.entities.Tutor;
import com.tutoring.springdatajpa.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Use this interface to perform CRUD op in our app code.
public interface TutorRepository extends CrudRepository<Tutor, Long>  {
//    List<Employee> findEmployeeByLastNameContaining(String str);

    List<Tutor> findUsersByIdContaining(String str);

    List<Tutor> searchTutorBySubjectName(String subject);

    List<Tutor> findByTutorSubjectListContaining(String subject);
    Tutor findByUsernameAndIsTutor(String username, boolean isTutor);
}

package com.tutoring.springdatajpa.repositories;

import com.tutoring.springdatajpa.entities.Appointment;
import com.tutoring.springdatajpa.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Use this interface to perform CRUD op in our app code.
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
//    List<Employee> findEmployeeByLastNameContaining(String str);

    List<Appointment> findUsersByIdContaining(String str);
}

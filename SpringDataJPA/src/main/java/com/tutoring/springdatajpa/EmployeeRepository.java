package com.tutoring.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Use this interface to perform CRUD op in our app code.
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
//    List<Employee> findEmployeeByLastNameContaining(String str);

    List<Employee> findEmployeesByLastNameContaining(String str);
}

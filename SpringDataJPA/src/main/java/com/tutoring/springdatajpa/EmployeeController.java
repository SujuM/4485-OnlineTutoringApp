package com.tutoring.springdatajpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {

        this.repository = repository;
    }

    @GetMapping("/employees")
    public List<Employee> index() {
        List<Employee> result = new ArrayList<Employee>();
         this.repository.findAll().forEach(result::add);
         return result;
    }

    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> show(@PathVariable long employeeId) {
        return this.repository.findById(employeeId);
    }

}

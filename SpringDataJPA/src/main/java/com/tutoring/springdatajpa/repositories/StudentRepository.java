package com.tutoring.springdatajpa.repositories;

import com.tutoring.springdatajpa.entities.Student;
import com.tutoring.springdatajpa.entities.Tutor;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}

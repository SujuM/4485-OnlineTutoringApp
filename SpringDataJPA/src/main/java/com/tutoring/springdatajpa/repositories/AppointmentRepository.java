package com.tutoring.springdatajpa.repositories;

import com.tutoring.springdatajpa.entities.Appointment;
import com.tutoring.springdatajpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Use this interface to perform CRUD op in our app code.
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//    List<Employee> findEmployeeByLastNameContaining(String str);

//    @Query("select a from Appointment a where a.student.id = :customerId")
    List<Appointment> findByStudentID(@Param("StudentID") int StudentID);

//    @Query("select a from Appointment a where a.tutor.id = :TutorID")
    List<Appointment> findByTutorID(@Param("TutorID") int TutorID);
}

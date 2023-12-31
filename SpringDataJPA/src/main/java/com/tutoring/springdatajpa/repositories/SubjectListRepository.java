package com.tutoring.springdatajpa.repositories;

import com.tutoring.springdatajpa.entities.Appointment;
import com.tutoring.springdatajpa.entities.SubjectList;
import com.tutoring.springdatajpa.entities.Tutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface SubjectListRepository extends CrudRepository<SubjectList, Long>
{
    Optional<SubjectList> findTutorsBySubjectName(String str);
//    Optional<SubjectList> findSubjectByFirstAndLastName(String str, String str2);
}

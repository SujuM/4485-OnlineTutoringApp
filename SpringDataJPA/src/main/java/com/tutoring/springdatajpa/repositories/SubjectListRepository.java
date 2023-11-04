package com.tutoring.springdatajpa.repositories;

import com.tutoring.springdatajpa.entities.Appointment;
import com.tutoring.springdatajpa.entities.SubjectList;
import com.tutoring.springdatajpa.entities.Tutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectListRepository extends CrudRepository<SubjectList, Long>
{
    Optional<SubjectList> findTutorsBySubjectName(String str);
    Optional<SubjectList> findSubjectByTutorName(String str);
}

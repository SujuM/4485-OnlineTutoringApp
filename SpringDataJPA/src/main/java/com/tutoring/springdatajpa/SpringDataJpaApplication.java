package com.tutoring.springdatajpa;


import com.tutoring.springdatajpa.entities.Appointment;
import com.tutoring.springdatajpa.entities.SubjectList;
import com.tutoring.springdatajpa.entities.Tutor;
import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.AppointmentRepository;
import com.tutoring.springdatajpa.repositories.SubjectListRepository;
import com.tutoring.springdatajpa.repositories.TutorRepository;
import com.tutoring.springdatajpa.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository, TutorRepository tutorRepository, AppointmentRepository appointmentRepository, SubjectListRepository subjectListRepository) {
        return (args) -> {
            //insertFourEmployees(repository);
            //System.out.println(repository.findAll());
            //System.out.println(repository.findEmployeesByLastNameContaining(" "));
            insertUsers(userRepository);
            System.out.println(userRepository.findAll());

            insertTutors(tutorRepository);
            System.out.println(tutorRepository.findAll());

            insertAppointments(appointmentRepository);
            System.out.println(appointmentRepository.findAll());

            insertSubjectList(subjectListRepository);
            System.out.println(subjectListRepository.findAll());

        };
    }
    /*
    private void insertFourEmployees(EmployeeRepository repository) {
        repository.save(new Employee("Dalia", "Abo Sheasha"));
        repository.save(new Employee("Trisha", "Gee"));
        repository.save(new Employee("Helen", "Scott"));
        repository.save(new Employee("Mala", "Gupta"));
    }
    */
    private void insertUsers(UserRepository repository) {
        repository.save(new User("johndoe@gmail.com", "Password123$"));
        repository.save(new User("janedoe@gmail.com", "passWord4#56"));
    }

    private void insertTutors(TutorRepository repository) {
        repository.save(new Tutor("tutor4u@yahoo.com", "passwoRd123*"));
        repository.save(new Tutor("johnsmith@hotmail.com", "qwertyeFjkfe&"));
    }

    private void insertAppointments(AppointmentRepository repository) {
        repository.save(new Appointment(1, 2, new Date(2023, 10, 20, 10, 0),
                new Date(2023, 10, 20, 11, 0),
                new Date(2023, 10, 19, 10, 0)));
    }
    private void insertSubjectList(SubjectListRepository repository) {
        repository.save(new SubjectList(1000, "Math", "Abigail Doe", 3294));
        repository.save(new SubjectList(1001, "Science", "Tessa Warren", 8774));
    }

}

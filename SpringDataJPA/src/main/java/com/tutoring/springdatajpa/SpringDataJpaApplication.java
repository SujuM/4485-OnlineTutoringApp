package com.tutoring.springdatajpa;

import com.tutoring.springdatajpa.entities.User;
import com.tutoring.springdatajpa.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(EmployeeRepository repository, UserRepository userRepository) {
        return (args) -> {
            insertFourEmployees(repository);
            System.out.println(repository.findAll());
            System.out.println(repository.findEmployeesByLastNameContaining(" "));
            insertUsers(userRepository);
        };
    }
    private void insertFourEmployees(EmployeeRepository repository) {
        repository.save(new Employee("Dalia", "Abo Sheasha"));
        repository.save(new Employee("Trisha", "Gee"));
        repository.save(new Employee("Helen", "Scott"));
        repository.save(new Employee("Mala", "Gupta"));
    }

    private void insertUsers(UserRepository repository) {
        repository.save(new User("johndoe@gmail.com", "password123"));
        repository.save(new User("janedoe@gmail.com", "password456"));
    }

}

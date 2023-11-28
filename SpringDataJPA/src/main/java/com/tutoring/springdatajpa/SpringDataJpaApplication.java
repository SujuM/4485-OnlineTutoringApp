package com.tutoring.springdatajpa;


import com.tutoring.springdatajpa.entities.*;
import com.tutoring.springdatajpa.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;

@SpringBootApplication
public class SpringDataJpaApplication {
    Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("*");
			}
		};
	}


    @Bean
    public CommandLineRunner run(UserRepository userRepository, TutorRepository tutorRepository, StudentRepository studentRepository,
                                 AppointmentRepository appointmentRepository, SubjectListRepository subjectListRepository) {
        return (args) -> {
            //insertFourEmployees(repository);
            //System.out.println(repository.findAll());
            //System.out.println(repository.findEmployeesByLastNameContaining(" "));
            insertUsers(userRepository);

            insertStudent(studentRepository);


            insertTutors(tutorRepository);
            //FavoritesService.addTutorToFavoriteList("johndoe@gmail.com","abigail36@gmail.com");

            insertAppointments(appointmentRepository, tutorRepository, studentRepository);

            insertSubjectList(subjectListRepository);

        };

    }

    private void insertUsers(UserRepository repository) {
      repository.save(new User("johndoe@gmail.com", "Password123$"));
        repository.save(new User("John", "Doe", "johndoe@gmail.com", "Password123$", false, false));
        repository.save(new User("Cal", "Henry", "calhenry@gmail.com", "Password123$", false, false));
    }

    private void insertStudent(StudentRepository repository) {
        repository.save(new Student("Cameron", "Fuller","student1@gmail.com", "Password123$"));
    }

    private void insertTutors(TutorRepository repository) {
          repository.save(new Tutor("My name is tara and I like  teaching Math. ", List.of("Math"), "tara_warren@gmail.com", "passWord4#56", true, false, "Tara", "Warren"));
          repository.save(new Tutor("My name is conrad and I like  teaching Science. ", List.of("Science"), "conrad_hawkins@gmail.com", "passWord4#56", true, false, "Conrad", "Hawkins"));
    }


    private void insertAppointments(AppointmentRepository appointmentRepository, TutorRepository tutorRepository, StudentRepository studentRepository) {
        Date startTime = new GregorianCalendar(2023, Calendar.FEBRUARY, 13, 11, 00).getTime();
        Date endTime = new GregorianCalendar(2023, Calendar.FEBRUARY, 13, 12, 00).getTime();
        Student student = studentRepository.findFirstByOrderByIdDesc();
        Tutor tutor = tutorRepository.findFirstByOrderByIdDesc();
        // Create new appointment with a tutor whose ID is 7
        Appointment appointment = new Appointment(tutor, startTime, endTime);
        appointmentRepository.save(appointment);

        // Add an appointment to the list of appointments for tutor.
//        appointment.setStudent(student);
//        appointmentRepository.save(appointment);
//
//        logger.warn(student.getAppointments().toString());
    }
    private void insertSubjectList(SubjectListRepository repository) {
        repository.save(new SubjectList(1000, "Math", "Abigail","Doe" ,3294));
        repository.save(new SubjectList(1001, "Science", "Tessa", "Warren", 8774));
    }

}

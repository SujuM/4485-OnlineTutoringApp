package com.tutoring.springdatajpa.repositories;

import com.tutoring.springdatajpa.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository might be better choice than CrudRepository.
// Use this interface to perform CRUD op in our app code.
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}

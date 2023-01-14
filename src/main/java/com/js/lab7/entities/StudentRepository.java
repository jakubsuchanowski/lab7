package com.js.lab7.entities;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.js.lab7.entities.Student;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Optional<Student> findById(Long id);

}

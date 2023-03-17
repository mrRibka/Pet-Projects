package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.lastName LIKE %?1%"
            + "OR s.firstName LIKE %?1%"
            + "OR s.email LIKE %?1%")
    List<Student> findAllByLastName(String lastName);
}

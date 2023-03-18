package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.lastName LIKE %?1%"
            + "OR s.firstName LIKE %?1%"
            + "OR s.email LIKE %?1%")
    Page<Student> findAll(Pageable pageable, String keyword);

    Page<Student> findAll(Pageable pageable);
}

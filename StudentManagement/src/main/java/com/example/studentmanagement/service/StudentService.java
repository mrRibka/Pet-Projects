package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import org.springframework.data.domain.Page;

public interface StudentService{

    Student saveStudent(Student student);

    Student getStudentById(Long student);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

    Page<Student> listAll( int pageNum, String keyword, String sortField, String sortDir );
}

package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService{
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long student);

    Student updateStudent(Student student);

    List<Student> getAllStudents(String keyword);

    void deleteStudentById(Long id);
}

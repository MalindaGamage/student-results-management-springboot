package com.example.student_results_management.service;

import com.example.student_results_management.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
}

package com.example.student_results_management.service;

import com.example.student_results_management.model.Student;
import com.example.student_results_management.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        logger.info("Saving student: {}", student);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        logger.info("Fetching student with id: {}", id);
        return studentRepository.findById(id).orElse(null);
    }
}

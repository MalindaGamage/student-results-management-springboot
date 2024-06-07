package com.example.student_results_management.repository;

import com.example.student_results_management.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
}

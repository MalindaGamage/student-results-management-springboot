package com.example.student_results_management.service;

import com.example.student_results_management.model.Result;

import java.util.List;

public interface ResultService {
    Result saveResult(Result result);
    List<Result> getResultsByStudentId(Long studentId);
    List<Result> getResultsBySubjectId(Long subjectId);
}

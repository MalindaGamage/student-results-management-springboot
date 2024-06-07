package com.example.student_results_management.controller;

import com.example.student_results_management.model.Result;
import com.example.student_results_management.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @PostMapping
    public Result saveResult(@RequestBody Result result) {
        return resultService.saveResult(result);
    }

    @GetMapping("/student/{studentId}")
    public List<Result> getResultsByStudentId(@PathVariable Long studentId) {
        return resultService.getResultsByStudentId(studentId);
    }

    @GetMapping("/subject/{subjectId}")
    public List<Result> getResultsBySubjectId(@PathVariable Long subjectId) {
        return resultService.getResultsBySubjectId(subjectId);
    }
}

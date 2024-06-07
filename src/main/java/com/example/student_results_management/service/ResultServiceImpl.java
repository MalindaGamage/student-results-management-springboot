package com.example.student_results_management.service;

import com.example.student_results_management.model.Result;
import com.example.student_results_management.model.Student;
import com.example.student_results_management.repository.ResultRepository;
import com.example.student_results_management.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String MOCK_API_URL = "https://d6d8e30921af49c185b582a57ec6a041.api.mockbin.io/";

    @Override
    public Result saveResult(Result result) {
        Student student = studentRepository.findById(result.getStudent().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + result.getStudent().getId()));
        result.setStudent(student);
        return resultRepository.save(result);
    }

    @Override
    public List<Result> getResultsByStudentId(Long studentId) {
        ResponseEntity<Object> response = restTemplate.getForEntity(MOCK_API_URL + "results?studentId=" + studentId, Object.class);
        Object responseBody = response.getBody();

        if (responseBody instanceof List) {
            return (List<Result>) responseBody;
        } else if (responseBody instanceof Map) {
            Result[] results = new ObjectMapper().convertValue(responseBody, Result[].class);
            return Arrays.asList(results);
        } else {
            throw new RuntimeException("Unexpected response type: " + responseBody.getClass().getName());
        }
    }


    @Override
    public List<Result> getResultsBySubjectId(Long subjectId) {
        ResponseEntity<Result[]> response = restTemplate.getForEntity(MOCK_API_URL + "results?subjectId=" + subjectId, Result[].class);
        return Arrays.asList(response.getBody());
    }
}

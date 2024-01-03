package com.scores.service;

import com.scores.model.Student;

import java.util.List;

public interface ScoresService {
    double calMedian(List<Student> scores);

    double calAvg(List<Student> scores);

    List<Student> getStudents(String classId);
}

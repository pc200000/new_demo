package com.scores.service;

import com.scores.model.Student;

import java.util.List;

public interface ScoresService {
    double calMedian(List<Student> scores);

    double calAvg(List<Student> scores);

    double passRate(List<Student> scores);

    double excelRate(List<Student> scores);



    List<Student> getStudents(String classId);
}

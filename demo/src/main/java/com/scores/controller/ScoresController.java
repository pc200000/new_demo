package com.scores.controller;

import com.scores.model.Student;
import com.scores.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoresController {
    @Autowired
    ScoresService scoresService;

    @GetMapping("/students/{classId}")
    public List<Student> getStudents(@PathVariable String classId) {
        return scoresService.getStudents(classId);
    }

    @GetMapping("/students/{classId}/median")
    public Double getMedian(@PathVariable String classId) {
        return scoresService.calMedian(scoresService.getStudents(classId));
    }

    @GetMapping("/students/{classId}/average")
    public Double getAverage(@PathVariable String classId) {
        return scoresService.calAvg(scoresService.getStudents(classId));
    }

    @GetMapping("/students/{classId}/passRate")
    public Double getPassRate(@PathVariable String classId) {
        return scoresService.calAvg(scoresService.getStudents(classId));
    }

    @GetMapping("/students/{classId}/excelRate")
    public Double getExcellenceRate(@PathVariable String classId) {
        return scoresService.calAvg(scoresService.getStudents(classId));
    }
}
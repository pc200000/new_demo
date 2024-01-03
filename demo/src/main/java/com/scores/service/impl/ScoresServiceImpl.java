package com.scores.service.impl;

import com.scores.dao.StudentMapper;
import com.scores.model.Student;
import com.scores.service.ScoresService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoresServiceImpl implements ScoresService {

    private StudentMapper studentMapper;

    @Override
    public double calMedian(List<Student> students) {
        if (students.isEmpty()) {
            return 0;
        }

        students.sort((s1, s2) -> Double.compare(s1.getScore(), s2.getScore()));

        int size = students.size();
        if (size % 2 == 0) {
            // 如果列表大小为偶数，中位数是两个中间数的平均值
            Student s1 = students.get(size / 2 - 1);
            Student s2 = students.get(size / 2);
            return (s1.getScore() + s2.getScore()) / 2;
        } else {
            // 如果列表大小为奇数，中位数是中间数
            return students.get(size / 2).getScore();
        }
    }

    @Override
    public double calAvg(List<Student> students) {
        if (students.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (Student student : students) {
            sum += student.getScore();
        }
        return sum / students.size();
    }

    @Override
    public double passRate(List<Student> students) {
        // 计算及格人数
        int passCount = 0;
        for (Student student : students) {
            if (student.getScore() >= 60) {
                passCount++;
            }
        }

        // 计算及格率
        double passRate = (double) passCount / students.size();
        return passRate * 100;
    }

    @Override
    public double excelRate(List<Student> students) {
        // 计算优秀人数
        int excellenceCount = 0;
        for (Student student : students) {
            if (student.getScore() >= 90) {
                excellenceCount++;
            }
        }

        // 计算优秀率
        double excellenceRate = (double) excellenceCount / students.size();
        return excellenceRate * 100;
    }

    public List<Student> getStudents(String classId) {
        // 调用 MyBatis 查询方法
        return studentMapper.getStudentsByClassId(classId);
    }
}


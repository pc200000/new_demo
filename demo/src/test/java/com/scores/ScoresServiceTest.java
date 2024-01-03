package com.scores;

import com.scores.model.Student;
import com.scores.service.ScoresService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ScoresServiceTest {

	@Autowired
	private ScoresService scoresService;

	@Test
	public void testGetStudentList(String classId) {
		// 调用 getStudentList 方法获取学生列表
		List<Student> studentList = scoresService.getStudents(classId);

		// 断言学生列表不为空
		Assertions.assertNotNull(studentList);
		// 断言学生列表中至少有一个学生
        Assertions.assertFalse(studentList.isEmpty());
	}

	@Test
	public void testScoresServiceMethods(String classId) {
		List<Student> studentList = scoresService.getStudents(classId);
		// 调用 calculateMedian 方法计算中位数
		double median = scoresService.calMedian(studentList);
		Assertions.assertNotSame(Double.NaN, median);

		// 调用 calculateAverage 方法计算平均值
		double average = scoresService.calAvg(studentList);
		Assertions.assertNotSame(Double.NaN, average);
	}

	@Test
	public void testPassRate(String classId) {
		List<Student> studentList = scoresService.getStudents(classId);

		double passRate = scoresService.passRate(studentList);
		// 及格率应为 60%
		Assertions.assertNotSame(Double.NaN, passRate);
	}

	@Test
	public void testExcellenceRate(String classId) {
		List<Student> studentList = scoresService.getStudents(classId);

		double excelRate = scoresService.excelRate(studentList);
		// 及格率应为 60%
		Assertions.assertNotSame(Double.NaN, excelRate);
	}
}

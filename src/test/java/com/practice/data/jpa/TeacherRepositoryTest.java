package com.practice.data.jpa;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.data.jpa.entity.Course;
import com.practice.data.jpa.entity.Teacher;
import com.practice.data.jpa.repository.TeacherRepository;

@SpringBootTest
public class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		Course courseDBA = Course.builder().courceTitle("DBA").credit(5).build();
		Course courseJAVA = Course.builder().courceTitle("JAVA").credit(1).build();
		Course courseJavaScript = Course.builder().courceTitle("JavaSCript").credit(3).build();
		Teacher teacher = Teacher.builder()
							.firstName("Kiran")
							.lastName("Kothawade")
							//.courses(Arrays.asList(courseDBA,courseJAVA,courseJavaScript))
							.build();
	
		teacherRepository.save(teacher);
	}
}

package com.practice.data.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.data.jpa.entity.Course;
import com.practice.data.jpa.entity.CourseMaterial;
import com.practice.data.jpa.repository.CourseMaterialRepository;

@SpringBootTest
public class CourseMaterialRepositoryTest {
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;

	@Test
	public void saveCourseMaterial() {
		
		Course course = Course.builder()
						.courceTitle("DSA")
						.credit(6)
						.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
										.url("www.youtube.com")
										.course(course)
										.build();
		courseMaterialRepository.save(courseMaterial);
	}
	
	@Test
	public void printAllCourceMaterials() {
		List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
		System.out.println("Course Materials : " + courseMaterials);
	}
}

package com.practice.data.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.practice.data.jpa.entity.Course;
import com.practice.data.jpa.entity.Student;
import com.practice.data.jpa.entity.Teacher;
import com.practice.data.jpa.repository.CourseRepository;

@SpringBootTest
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void printCourse() {
		List<Course> courses = courseRepository.findAll();
		System.out.println("All Courses : " + courses);
	}
	
	@Test
	public void saveCourseWithTeacher() {
		
		Teacher teacher = Teacher.builder()
				.firstName("Rajenra")
				.lastName("Joshi")
				.build();
		
		Course course = Course.builder()
				.courceTitle("Python")
				.credit(4)
				.teacher(teacher)
				.build();
		
		courseRepository.save(course);
	}
	
	@Test
	public void findAllPaginantion() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		
		Pageable secondPageWithThreeRecords = PageRequest.of(1, 2);
		
		List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
		long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
		long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
		
		System.out.println("Total Elements on DB " + totalElements);
		System.out.println("Total Pages in DB : " + totalPages);
		System.out.println("Cources on first Page : - " + courses);
	}

	@Test
	public void findAllSorting() {
		Pageable sortByTitle = PageRequest.of(0,2,Sort.by("courceTitle"));
		
		Pageable sortByCreditDec = PageRequest.of(1, 2, Sort.by("credit").descending());
		
		Pageable sortByTitalAndCreditDesc = PageRequest.of(1, 3, Sort.by("courceTitle").descending().and(Sort.by("credit")));
		
		List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
		
		System.out.println("Sorted Cources : " + courses);
	}
	
	
	@Test
	public void printByTitleContaining() {
		Pageable firstPageTenRecords = PageRequest.of(0, 10);
		
		List<Course> courses = courseRepository.findByCourceTitleContaining("J", firstPageTenRecords).getContent();
		
		System.out.println("Cources based on Title containing : " + courses);
	}
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		
		Teacher teacher = Teacher.builder()
				.firstName("Ramakant")
				.lastName("Ekhande")
				.build();
		
		Student student = Student.builder()
				.firstName("Ketan")
				.lastName("Braris")
				.emailId("ketan@gmail.com")
				.build();
		
		Course course = Course.builder()
				.courceTitle("AI")
				.credit(12)
				.teacher(teacher)
				.build();

		course.addStudents(student);
		
		courseRepository.save(course);
	}
	
}

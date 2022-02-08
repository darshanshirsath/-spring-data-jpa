package com.practice.data.jpa;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.data.jpa.entity.Guardian;
import com.practice.data.jpa.entity.Student;
import com.practice.data.jpa.repository.StudentRepository;


@SpringBootTest
@Disabled
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Disabled
	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.firstName("Darshan")
				.lastName("Shirsath")
				.emailId("darshanshirsath09@gmail.com")
				/*
				 * .guardianName("Ashok") .guardianEmail("medash4247@gmail.com")
				 * .guardianMobile("1234567890")
				 */
				.build();
		
		studentRepository.save(student);
		System.out.println("Student is saved");
	}
	
	@Disabled
	@Test
	public void printAllStudents() {
		List<Student> studentList = studentRepository.findAll();
		
		System.out.println("studentList : " + studentList.toString());
	}
	
	@Disabled
	@Test
	public void saveStudentwithGuardian(){
		Guardian guardian = Guardian.builder()
							.name("Ashok")
							.email("ashokpatil@gmail.com")
							.mobile("1234567891")
							.build();
		
		Student student = Student.builder()
							.firstName("Krishna")
							.lastName("Patil")
							.emailId("shirsathdarshan83@gmail.com")
							.guardian(guardian)
							.build();
		studentRepository.save(student);
	}
	
	@Test 
	public void pringStudentByFirstName() {
		List<Student> students = studentRepository.findByFirstName("Krishna");
		System.out.println("Students First Name: " + students);
	}
	
	@Test 
	public void printStudentByFirstNameContaining() {
		List<Student> students = studentRepository.findByFirstNameContaining("Dars");
		System.out.println("Students containing : " + students);
	}
	
	@Test 
	public void printStudentBasedOnGuardianName() {
		List<Student> students = studentRepository.findByGuardianName("Ashok");
		System.out.println("Students with Guardian : " + students);
	}
	
	@Test 
	public void printStudentBasedByEmailAddress() {
		Student student = studentRepository.getStudentByEmailId("darshanshirsath09@gmail.com");
		System.out.println("Student by email : " + student);
	}
	
	@Test 
	public void printStudentFirstNameBasedByEmailAddress() {
		String studentFirstName = studentRepository.getStudentFirstNameByEmailId("darshanshirsath09@gmail.com");
		System.out.println("Student First Name by email : " + studentFirstName);
	}
	
	@Test 
	public void printStudentBasedByEmailAddressNative() {
		Student student = studentRepository.getStudentByEmailIdNative("darshanshirsath09@gmail.com");
		System.out.println("Student by email Native : " + student);
	}
	
	@Test 
	public void printStudentBasedByEmailAddressNativeParam() {
		Student student = studentRepository.getStudentByEmailIdNativeParam("darshanshirsath09@gmail.com");
		System.out.println("Student by email Native Param: " + student);
	}
	
	@Test
	public void updateFirstNameByEmailAddress() {
		int result = studentRepository.updateStudentFirstNameByEmailId("Darshan", "darshanshirsath09@gmail.com");
		System.out.println(result + " Sudent First Name is updated");
		
	}
}

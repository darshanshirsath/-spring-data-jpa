package com.practice.data.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.data.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByFirstNameContaining(String name);
	
	public List<Student> findByLastNameNotNull();
	
	public List<Student> findByGuardianName(String guardianName);
	
	public List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	
	//JPQL Query - 
	
	// JPQL query are defined based on class name or class
	//attributes not on table name or column name
	  
	@Query("select s from Student s where s.emailId = ?1") 
	Student getStudentByEmailId(String emailId);
	 
	  
	@Query("select s.firstName from Student s where s.emailId = ?1") 
	String getStudentFirstNameByEmailId(String emailId);
	
	
	//Native Query
	
	// Native query are defined based on table name or column name 
	// not on class name or class attributes
	@Query(
			value = "Select * from tbl_student s where s.email_address = ?1",
			nativeQuery = true
			)
	Student getStudentByEmailIdNative(String emailId);
	
	//Native Named Param
	@Query(
			value = "Select * from tbl_student s where s.email_address =:emailId",
			nativeQuery = true
			)
	Student getStudentByEmailIdNativeParam(@Param("emailId")String emailId);
	
	@Modifying
	@Query(
			value = "Update tbl_student s set s.first_name =?1 where s.email_address =?2",
			nativeQuery = true
			)
	@Transactional
	int updateStudentFirstNameByEmailId(String firstName, String emailId);
	
}



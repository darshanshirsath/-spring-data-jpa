package com.practice.data.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
	@Id
	@SequenceGenerator(
				name ="teacherSequense",
				sequenceName = "teacherSequense",
				allocationSize = 1
			)
	@GeneratedValue(
				strategy = GenerationType.SEQUENCE,
				generator = "teacherSequense"
			)
	private long teacherId;
	private String firstName;
	private String lastName;
	
//	@OneToMany(
//				cascade = CascadeType.ALL
//			)
//	@JoinColumn(
//				name="teacher_id",
//				referencedColumnName = "teacherId"
//			)
//	private List<Course> courses;
}

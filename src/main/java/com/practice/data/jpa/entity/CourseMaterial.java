package com.practice.data.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial{
	@Id
	@SequenceGenerator(
				name ="courseMaterial_Sequence",
				sequenceName = "courseMaterial_Sequence",
				allocationSize = 1
			)
	@GeneratedValue(
				strategy = GenerationType.SEQUENCE,
				generator = "courseMaterial_Sequence"
			)
	private long courceMaterialId;
	private String url;
	
	@OneToOne(
				cascade = CascadeType.ALL,
				fetch = FetchType.LAZY,
				optional = false
			)
	@JoinColumn(
				name = "cource_id",
				referencedColumnName = "courceId"
			)
	private Course course;
}

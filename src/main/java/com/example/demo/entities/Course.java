package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer course_id;
	
	@Column(name="course_name",length=100,nullable=false)
	private String name;
	
	@Column(length=10000)
	private String description;
	
	@Column(name="subject",length=100,nullable=false)
	private String subject;
	
	private int numOfClasses;
	
	@ManyToOne
	private User user;
	
	private String type;
	
	private String learnMode;
	
}

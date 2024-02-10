package com.example.demo.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CourseDto {
	
	private Integer course_id;
	
	@NotEmpty
	@Size(min = 5,message="Course name must be of atleast 5 characters.")
	private String name;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	private String subject;
	
	@NotNull
	private int numOfClasses;
	
	private UserDto user;
	
	@NotEmpty
	private String type;
	
	@NotEmpty
	private String learnMode;
}

package com.example.demo.services;

import java.util.List;

import com.example.demo.payloads.CourseDto;

public interface CourseService {

	CourseDto createCourse(CourseDto course, Integer courseId);

	CourseDto updateCourse(CourseDto course, Integer courseId);
	
	List<CourseDto> getCoursesByUser(Integer userId);

	CourseDto getCourseById(Integer courseId);
}

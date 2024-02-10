package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payloads.CourseDto;
import com.example.demo.services.CourseService;

@Controller
@RequestMapping("/api/")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/user/{userId}/course/create")
	public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto CourseDto, @PathVariable Integer userId) {
		CourseDto createCourse = this.courseService.createCourse(CourseDto, userId);
		return new ResponseEntity<CourseDto>(createCourse, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}/course/get")
	public ResponseEntity<List<CourseDto>> getCoursesByUser(@PathVariable Integer userId) {

		List<CourseDto> posts = this.courseService.getCoursesByUser(userId);
		return new ResponseEntity<List<CourseDto>>(posts, HttpStatus.OK);

	}
	
	@GetMapping("/courses/{courseId}/get")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable Integer courseId) {

		CourseDto courseDto = this.courseService.getCourseById(courseId);
		return new ResponseEntity<CourseDto>(courseDto, HttpStatus.OK);

	}
	
	@PutMapping("/courses/{courseId}/update")
	public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto, @PathVariable Integer courseId) {

		CourseDto updatedCourse = this.courseService.updateCourse(courseDto, courseId);
		return new ResponseEntity<CourseDto>(updatedCourse, HttpStatus.OK);

	}
}

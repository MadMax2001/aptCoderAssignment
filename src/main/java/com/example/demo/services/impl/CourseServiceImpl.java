package com.example.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;
import com.example.demo.entities.User;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.payloads.CourseDto;
import com.example.demo.repositories.CourseRepo;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Override
	public CourseDto createCourse(CourseDto courseDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
		Course course= this.modelMapper.map(courseDto, Course.class);
		course.setUser(user);
		Course newCourse = this.courseRepo.save(course);
		
		return this.modelMapper.map(newCourse, CourseDto.class);
		
	}

	@Override
	public CourseDto updateCourse(CourseDto courseDto, Integer courseId) {
		Course course = this.courseRepo.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Course","course id", courseId));
		course.setName(courseDto.getName());
		course.setDescription(course.getDescription());
		course.setNumOfClasses(course.getNumOfClasses());
		Course updatedCourse = this.courseRepo.save(course);
		
		return this.modelMapper.map(updatedCourse,CourseDto.class);
	}

	@Override
    public List<CourseDto> getCoursesByUser(Integer userId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User ", "userId ", userId));
        List<Course> courses = this.courseRepo.findByUser(user);

        List<CourseDto> courseDtos = courses.stream().map((course) -> this.modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());

        return courseDtos;
    }
	
	@Override
	public CourseDto getCourseById(Integer courseId) {
		Course course = this.courseRepo.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Course","course id", courseId));
		return this.modelMapper.map(course, CourseDto.class);
	}
	
	
}

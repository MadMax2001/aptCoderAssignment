package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Course;
import com.example.demo.entities.User;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>{
	List<Course> findByUser(User user);
}

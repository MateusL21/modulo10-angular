package com.spring.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.java.models.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{
    
}
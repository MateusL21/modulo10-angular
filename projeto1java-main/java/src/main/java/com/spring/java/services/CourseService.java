package com.spring.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.java.models.Course;
import com.spring.java.repositories.CourseRepository;
import com.spring.java.repositories.StudentRepository;

@Service
public class CourseService {

     @Autowired
    private CourseRepository courseRepository;


     public Course getById(int id){
         Course course = courseRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));

        return course;
    }

    public List <Course> getAll(){
        return courseRepository.findAll();
    }
    
}

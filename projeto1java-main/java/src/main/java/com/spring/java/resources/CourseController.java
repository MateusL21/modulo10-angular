package com.spring.java.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.java.models.Course;
import com.spring.java.services.CourseService;

@RestController
@CrossOrigin
public class CourseController {
    
       @Autowired
       private CourseService courseService;


    @GetMapping("courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id){

        Course course = courseService.getById(id);

                               return ResponseEntity.ok(course);
    }                                          

    @GetMapping("courses")
    public List<Course> getCourses() {
        return courseService.getAll();
    }
    
}
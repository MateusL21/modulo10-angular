package com.spring.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.java.models.Course;
import com.spring.java.models.Student;
import com.spring.java.repositories.CourseRepository;
import com.spring.java.repositories.StudentRepository;

@Service
public class StudentService {

     @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseService courseService;

    
    public Student getById(int id){
         Student student = studentRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));

        return student;
    }

    public List <Student> getAll(){
        return studentRepository.findAll();
    }

    public Student save(Student student){
        return studentRepository.save(student);

    }

    public void deleteById(int id){
        
        Student student = getById(id);

        studentRepository.delete(student);
    }

    public void update(int id, Student studentUpdate){
        Student student = getById(id);

        if(studentUpdate.getCourse() == null){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course can not be empty");
        }

        Course course = courseService.getById(studentUpdate.getCourse().getId());

        student.setCourse(studentUpdate.getCourse());
        student.setEmail(studentUpdate.getEmail());
        student.setId(studentUpdate.getId());
        student.setName(studentUpdate.getName());
        student.setPeriod(studentUpdate.getPeriod());
        student.setPhone(studentUpdate.getPhone());
        

        studentRepository.save(student);
    }
}

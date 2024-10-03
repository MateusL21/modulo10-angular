package com.spring.java.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.java.models.Student;
import com.spring.java.services.StudentService;


@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("students")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        
        student = studentService.save(student);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student.getId())
                .toUri();

        return ResponseEntity.created(location).body(student);

    }

    @GetMapping("students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Student student = studentService.getById(id);
       
        return ResponseEntity.ok(student);
    }


    @GetMapping("students")
    public List<Student> getStudents() {
        return studentService.getAll();
       
    }

    @DeleteMapping("students/{id}")
    public ResponseEntity<Void> removeStudent(@PathVariable int id) {

        studentService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("students/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable int id, @RequestBody Student studentUpdate) {
        studentService.update(id, studentUpdate);
        return ResponseEntity.ok().build(); 
    }

}
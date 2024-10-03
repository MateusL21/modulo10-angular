package com.spring.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.java.models.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
    
}

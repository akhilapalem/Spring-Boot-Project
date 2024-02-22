package com.vcube.batch567.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vcube.batch567.model.Student;

@Service
public interface StudentService {
	
        public Student createStudent(Student student);
        
        public List<Student> getAllStudents();
        
        public Optional<Student> findByStudentId(long studentId);
        
        public Student save(Student student);
        
        public String delete(long studentId);
        
   }



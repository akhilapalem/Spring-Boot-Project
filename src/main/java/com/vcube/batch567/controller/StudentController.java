package com.vcube.batch567.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.batch567.exception.ResourceNotFoundException;
import com.vcube.batch567.model.Student;
import com.vcube.batch567.service.StudentServiceImpl;



@CrossOrigin(origins = "http://localhost:3306")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
    private StudentServiceImpl studentService;
	
	@PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {
    //displaying student object in console for confirmation
    System.out.println(student);
    return studentService.createStudent(student);
    }
	
	@GetMapping("/students")
    public List<Student> getAllStudents() {
    //storing return type of Student Entity
		return studentService.getAllStudents();
    }
	
	@GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId)
    throws ResourceNotFoundException {
    Student student = studentService.findByStudentId(studentId).orElseThrow(() -> new ResourceNotFoundException("student not found for this id :: " + studentId));
    return ResponseEntity.ok().body(student);
	}
    
	@PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,@Valid @RequestBody Student studentDetails) 
    throws ResourceNotFoundException {
    Student student = studentService.findByStudentId(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
    student.setFirstName(studentDetails.getFirstName());
    final Student updatedStudent = studentService.save(student);
    return ResponseEntity.ok(updatedStudent);

	}
	
	@DeleteMapping("/students/{id}")
	public String delete(@PathVariable(value = "id") long studentId){
		return studentService.delete(studentId);
		
	}
}

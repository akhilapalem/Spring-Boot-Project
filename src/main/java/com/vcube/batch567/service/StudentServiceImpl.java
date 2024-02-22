package com.vcube.batch567.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.vcube.batch567.model.Student;
import com.vcube.batch567.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService  {
	
	@Autowired
	private StudentRepository studentRepository;
	
    @Override
    public Student createStudent(Student student) {
    return studentRepository.save(student);
    }
	
    public List<Student> getAllStudents(){
    	//List<Student> studList = new ArrayList<>();
    	 return studentRepository.findAll();//.forEach(studList::add);
    	 //return studList;
    }
    
    public Optional<Student> findByStudentId(long studentId){
    	return studentRepository.findById(studentId);
      } 
    
    
    public Student save(Student student) {
        // TODO Auto-generated method stub
        return studentRepository.save(student);
     }
    
   
    
    public String delete(long studentId){
    	studentRepository.deleteById(studentId);
    	return "Record deleted";
    }


}

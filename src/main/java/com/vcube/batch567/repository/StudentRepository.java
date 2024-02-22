package com.vcube.batch567.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.batch567.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}

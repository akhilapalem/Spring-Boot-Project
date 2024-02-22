package com.vcube.batch567.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	private long id;
    private String firstName;
    
    public Student(){}
    
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Student(long id, String firstName ){
    	this.id = id;
    	this.firstName = firstName;
    }
	
	@Override
    public String toString() {
    return "Student [id=" + id + ", firstName=" + firstName +"]";
    }

	

}

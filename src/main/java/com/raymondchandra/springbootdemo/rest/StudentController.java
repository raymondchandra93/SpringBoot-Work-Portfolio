package com.raymondchandra.springbootdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raymondchandra.springbootdemo.exceptions.StudentErrorResponse;
import com.raymondchandra.springbootdemo.exceptions.StudentNotFoundException;
import com.raymondchandra.springbootdemo.model.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	private List<Student> students; 
	
	@PostConstruct
	public void init() {
		
		students = new ArrayList<>();
		
		students.add(new Student("John", "Doe", "john.doe@email.com"));
		students.add(new Student("Jane", "Doe", "jane.doe@email.com"));
		students.add(new Student("Foo", "Bar", "food.bar@email.com"));
	}

	@GetMapping
	public List<Student> getStudents() {
		
		return students;
	}

	@GetMapping("/{studentId}")
	public Student getStudents(@PathVariable int studentId) {
		
		// Check for the student id
		if( studentId >= students.size() || studentId < 0 ) {
			throw new StudentNotFoundException("Student ID is not found - " + studentId);
		}
		
		// If not, return the happy path
		return students.get(studentId);
	}
}

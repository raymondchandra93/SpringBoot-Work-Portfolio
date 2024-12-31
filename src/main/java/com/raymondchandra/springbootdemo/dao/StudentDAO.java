package com.raymondchandra.springbootdemo.dao;

import java.util.List;

import com.raymondchandra.springbootdemo.model.Student;

public interface StudentDAO {
	// Create
	void save(Student student);
	
	// Read
	Student findById(Integer id);
	List<Student> findAll();
	List<Student> findByLastName(String lastName);
	
	// Update
	void update(Student student);
	int updateLastName(String lastName);
	
	// Delete
	void delete(Integer id);
	int deleteAll();
}

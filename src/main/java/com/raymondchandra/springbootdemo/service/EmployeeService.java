package com.raymondchandra.springbootdemo.service;

import java.util.List;

import com.raymondchandra.springbootdemo.model.Employee;

public interface EmployeeService {
	// Create / Update
	Employee createUpdateEmployee(Employee emp);
	
	// Read
	List<Employee> findAll();
	Employee findById(int id);
	Employee findByEmail(String email);
		
	// Delete
	void deleteEmployee(int id);
}

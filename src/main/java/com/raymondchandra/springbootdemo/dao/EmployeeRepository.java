package com.raymondchandra.springbootdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raymondchandra.springbootdemo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}

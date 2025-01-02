package com.raymondchandra.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raymondchandra.springbootdemo.dao.EmployeeRepository;
import com.raymondchandra.springbootdemo.exceptions.EmployeeNotFoundException;
import com.raymondchandra.springbootdemo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee createUpdateEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee emp = null;
		
		if(result.isPresent()) {
			emp = result.get();
		} else {
			throw new EmployeeNotFoundException("Employee with ID: " + id + " not found!");
		}
		
		return emp;
	}

	@Override
	public Employee findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee emp = null;
		
		if(result.isPresent()) {
			emp = result.get();
		} else {
			throw new EmployeeNotFoundException("Employee with ID: " + id + " not found!");
		}
		
		employeeRepository.deleteById(id);
	}
}

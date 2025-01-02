package com.raymondchandra.springbootdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raymondchandra.springbootdemo.model.Employee;
import com.raymondchandra.springbootdemo.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List<Employee> getEmployees() {
		
		return employeeService.findAll();
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		
		return employeeService.findById(employeeId);
	}
	
	@PostMapping
	public Employee createStudent(@RequestBody Employee employee) {
		
		employee.setId(0);
		Employee newEmployee = employeeService.createUpdateEmployee(employee);
		
		return newEmployee;
	}
	
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		Employee updatedEmployee = employeeService.createUpdateEmployee(employee);
		
		return updatedEmployee;
	}
	
	@DeleteMapping("/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		employeeService.deleteEmployee(employeeId);
		
		return "Deleted employee id - " + employeeId;
		
	}
}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.repositoryTests.EmployeeRepository;

@Service
public class EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	public String saveEmployee(Employee e) {
		String result="";
	
		Employee obj = null;
//		if(e.getEmployeeId() == null) {
//			obj = employeeRepo.save(e);
//			if(obj!=null)
//			result="User saved";
//			else
//			result="Registration failed";
//		
//		}
//		else {
//			result = "USer is existing";
//		}
		Optional<Employee> optional = employeeRepo.findById(e.getEmployeeId());
		if(optional.isPresent())
		{
			result="User is existing";
			
		}
		else
		{
			obj = employeeRepo.save(e);
			if(obj!=null)
			result="User saved";
			else
			result="Registration failed";
		
		}
		return result;
	}
	
	public String loginEmployee(Login l) {
		String result = "";
		Employee e = null;
		Optional<Employee> optional = employeeRepo.findById(l.getEmployeeId());
		if(optional.isPresent()) {
			e = optional.get();
//			e.setEmployeeId(l.getUsername()); 
			if(e.getPassword().equals(l.getPassword())) {
				result = "Login Successful";
			}
			else {
				result = "Login failed";
			}
		}
		else {
			result = " Login failed, user doesn't exist";
		}
		return result;
	}
	public List<Employee> getAllEmployees()
	{
		
		return employeeRepo.findAll();
	}
	
}
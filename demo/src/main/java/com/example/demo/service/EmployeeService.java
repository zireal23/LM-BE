package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	public String saveEmployee(Employee e) {
		String result="";
	
		Employee obj = null;
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
	
}
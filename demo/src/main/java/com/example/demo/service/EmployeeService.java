package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.model.Employee;
import com.example.demo.model.Loan;
import com.example.demo.model.Login;
import com.example.demo.model.UserdashboardDetails;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

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
			try {
				obj = employeeRepo.save(e);
			}
			catch (IllegalArgumentException exception){
				result = "Cannot save User";
			}
            result="User saved";
		
		}
		return result;
	}

	public Optional<Employee> getEmployeeByID(String employeeID){
        return employeeRepo.findById(employeeID);
	}
	
	public UserdashboardDetails loginEmployee(Login l) {
		UserdashboardDetails userdashdetails = null;
		Employee e = null;
		Optional<Employee> optional = employeeRepo.findById(l.getEmployeeId());
		String employeeName = "";
		String department = "";
		String designation = "";
		String result = "";
		if(optional.isPresent()) {
			e = optional.get();
//			e.setEmployeeId(l.getUsername()); 
			if(e.getPassword().equals(l.getPassword())) {
				employeeName = e.getEmployeeName();
				department = e.getDepartment();
				designation = e.getDesignation();
				result = "Login Successful";
			}
			else {
				result = "Login failed";
			}
		}
		else {
			result = " Login failed, user doesn't exist";
		}
		
		userdashdetails = new UserdashboardDetails(employeeName, designation, department, result);
		
		return userdashdetails;
	}
	
	public List<Employee> getAllEmployees()
	{
		
		return employeeRepo.findAll();
	}
	
	public List<Employee> fetchEmployees(){
		List<Employee> employees = employeeRepo.findAll();
		if(employees.isEmpty())
			throw new NoResultException();
		return employees;
	}
	
	public String editEmployee(Employee e) {
		String result="";
		
		Employee obj = null;
		Optional<Employee> optional = employeeRepo.findById(e.getEmployeeId());
		try{
			obj = employeeRepo.save(e);
			result = "Employee updated successfully";
		}
		catch(IllegalArgumentException Exception){
			result = "Employee not updated successfully";
		}


		return result;
	}
	
	public String deleteEmployee(String employeeId) {
		String result="";
		
		Employee obj = null;
		
//		Optional<Loan> optional = loanRepo.findById(l.getLoanId());
		
		Optional<Employee> optional = employeeRepo.findById(employeeId);
		//System.out.println(employeeId);
		System.out.println(optional.isPresent());
		if(optional.isPresent()) {
			try{
				employeeRepo.deleteById(employeeId);
				result = "Deleted successfully";
			}
			catch(IllegalArgumentException Exception) {
				result = "Delete Unsuccessful";
			}
		}
		else {
			result = "Unable to delete";
		}
		return result;
	}
	
	
}
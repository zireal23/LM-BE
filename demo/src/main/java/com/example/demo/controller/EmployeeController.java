package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.Loan;
import com.example.demo.model.Login;
import com.example.demo.model.UserdashboardDetails;
import com.example.demo.service.EmployeeService;

@RestController
@CrossOrigin("*")
@Validated
public class EmployeeController{
	@Autowired
	private EmployeeService employeeService;
	private Login logincreds;

	public EmployeeController() {
	}

	@GetMapping("/showemp")
	public String showMessage() {
		return "Welcome";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@Valid @RequestBody Employee e) {
		String result = "";
		result = employeeService.saveEmployee(e);
	/*	if(obj != null) {
			result = "User data saved";
		}
		else {
			result = "Insertion failed";
		}*/
		
		return result;
	}
	
	@GetMapping("/fetchEmployees")
	public List<Employee> fetchEmployees(){
		return employeeService.fetchEmployees();
	}
	
	@PostMapping("/login")
	public UserdashboardDetails login(@RequestBody Login l) {
		UserdashboardDetails result = null;
		result = employeeService.loginEmployee(l);
		return result;
	}
	
	@PutMapping("/editempbyid")
	public String editEmployee(@Valid @RequestBody Employee e) {
		return employeeService.editEmployee(e);
	}
	
	@DeleteMapping("/deleteempbyid")
	public String deleteEmployee(@RequestParam String employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}
	
}


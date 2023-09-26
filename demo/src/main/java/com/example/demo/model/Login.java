package com.example.demo.model;

import javax.validation.constraints.NotEmpty;

public class Login {

	private String employeeId;

	private String password;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setemployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

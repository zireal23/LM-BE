package com.example.demo.model;

public class UserdashboardDetails {
	String employeeName;
	String designation;
	String department;
	String result;
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public UserdashboardDetails(String employeeName, String designation, String department, String result) {
		super();
		this.employeeName = employeeName;
		this.designation = designation;
		this.department = department;
		this.result = result;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}

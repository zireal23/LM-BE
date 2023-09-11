package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "employee_id", nullable = false)
	private int employeeId;
	
	@Column(name = "employeename")
	private String employeeName;
	
	@Column(name = "employeefullname")
	private String employeeFullName;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "gender", nullable = false)
	private char gender;
	
	@Column(name = "dateofjoining")
	private Date dateofjoining;
	
	@Column(name = "dateofbirth")
	private Date dateofbirth;
	
	@OneToMany(mappedBy = "employee")
	private List<EmployeeIssueDetails> employeeissue;
	
	@OneToMany(mappedBy = "employee")
	private List<EmployeeCardDetails> employeecard;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmployeeFullName() {
		return employeeFullName;
	}

	public void setEmployeeFullName(String employeeFullName) {
		this.employeeFullName = employeeFullName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getDateofjoining() {
		return dateofjoining;
	}

	public void setDateofjoining(Date dateofjoining) {
		this.dateofjoining = dateofjoining;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
}

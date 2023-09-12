package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "employee_id", nullable = false)
	private int employeeId;
	
	@Column(name = "employeename")
	@NotEmpty(message="Employee Name is a required field")
	private String employeeName;
	
	@Column(name = "designation")
	@NotEmpty(message="Designation is a required field")
	private String designation;
	
	@Column(name = "department")
	@NotEmpty(message="Designation is a required field")
	private String department;
	
	@Column(name = "gender", nullable = false, length=1)
	@NotEmpty(message="Gender is a required field")
	private String gender;
	
	@Column(name = "dateofjoining")
	@NotNull(message="Date of joining is a required field")
	private Date dateofjoining;
	
	@Column(name = "dateofbirth")
	@NotNull(message="Date of birth is a required field")
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


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
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
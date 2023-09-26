package com.example.demo.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Loan {

	@Id
	@Column(name = "loan_id")
	private int loanId;

	@Column(name = "loan_type", length = 30, nullable = false)
	@NotBlank // Ensures that loanType is not blank (not an empty string)
	@Size(max = 30) // Limits the maximum length of loanType to 30 characters
	private String loanType;

	@Column(name = "duration", nullable = false)
	@PositiveOrZero // Ensures that duration is a positive or zero value
	private int duration;

	@OneToMany(mappedBy = "loan")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<EmployeeCardDetails> employeeCardDetails;

	public Loan(int loanId, String loanType, int duration) {
		this.loanId = loanId;
		this.loanType = loanType;
		this.duration = duration;
	}
	//	@ManyToOne
//	@JoinColumn(name = "employee_id")
//	private Employee employee;
//	
	
	
	
	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public int getDuration()
	{
		return duration;
	}
	public void setDuration(int duration)
	{
		this.duration=duration;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}


	public List<EmployeeCardDetails> getEmployeeCardDetails() {
		return employeeCardDetails;
	}

	public void setEmployeeCardDetails(List<EmployeeCardDetails> employeeCardDetails) {
		this.employeeCardDetails = employeeCardDetails;
	}



	public Loan() {
	}

}

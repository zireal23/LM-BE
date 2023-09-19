package com.example.demo.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Loan {

	@Id
	@Column(name = "loan_id")
	private int loanId;
	@Column(name = "loan_type", length = 30, nullable = false)
	private String loanType;
	@Column(name = "duration", nullable = false)
	private int duration;
	
	
	@OneToMany(mappedBy = "loan", cascade = CascadeType.ALL)
	private List<EmployeeCardDetails> employeecarddetails;

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

<<<<<<< HEAD
	public List<EmployeeCardDetails> getEmployeecarddetails() {
		return employeecarddetails;
	}

	public void setEmployeecarddetails(List<EmployeeCardDetails> employeecarddetails) {
		this.employeecarddetails = employeecarddetails;
	}


=======
	public Loan() {
	}
>>>>>>> 8d2bf3541d99f230e3dd613709df72e84626870d
}

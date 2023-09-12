package com.example.demo.model;

import java.sql.Date;
import java.util.List;

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
	@Column(name = "card_issue_date", length = 10, nullable = false)
	private Date issueDate;
	
	@OneToMany(mappedBy = "loan")
	private List<EmployeeCardDetails> employeecarddetails;
	
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
	public Date getIssueDate()
	{
		return issueDate;
	}
	public void setIssueDate(Date issueDate)
	{
		this.issueDate=issueDate;
	}

}

package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EmployeeCardDetails{
	
	@Id
	@Column(name="employee_card_details_id")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "loan_id")
	private Loan loan;
	
	public Date getCard_issue_date() {
		return card_issue_date;
	}

	public void setCard_issue_date(Date card_issue_date) {
		this.card_issue_date = card_issue_date;
	}

	private Date card_issue_date;

	public EmployeeCardDetails(Employee employee, Loan loan, Date card_issue_date) {
		super();
		this.employee = employee;
		this.loan = loan;
		this.card_issue_date = card_issue_date;
	}

	
	
	
}

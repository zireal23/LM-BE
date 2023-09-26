package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EmployeeCardDetails {

	@Id
	@Column(name = "employee_card_details_id")
	@GeneratedValue // This generates an auto-incremented primary key
	private int id;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	@NotNull // Ensures that employee is not null
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "loan_id")
	private Loan loan;

	@Column(name = "card_issue_date")
	@NotNull // Ensures that card_issue_date is not null
	@Past(message = "Card issue date must be in the past") // Ensures that card_issue_date is a past date
	private Date card_issue_date;

	// Getter and Setter methods...

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "loan_id")
	private Loan loan;

	public Date getCard_issue_date() {
		return card_issue_date;
	}

	public void setCard_issue_date(Date card_issue_date) {
		this.card_issue_date = card_issue_date;
	}
}

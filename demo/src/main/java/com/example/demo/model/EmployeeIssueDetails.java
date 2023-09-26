package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
public class EmployeeIssueDetails {
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	@Id
	@Column(name = "issue_id")
	@GeneratedValue // This generates an auto-incremented primary key
	private int issue_id;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	@NotNull
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	@NotNull
	private Item item;
	
	@Column(name = "issue_date")
	@Temporal(TemporalType.DATE)
	@Past(message = "Issue date must be in the past") // Ensures that issueDate is a past date
	private Date issueDate;
	
	@Column(name="return_date")
	@Temporal(TemporalType.DATE)
	private Date returnDate;
	
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getIssue_id() {
		return issue_id;
	}
	public void setIssue_id(int issue_id) {
		this.issue_id = issue_id;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
}

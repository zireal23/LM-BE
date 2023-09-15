package com.example.demo.model;

import java.util.Date;

public class UserLoan {
	private int loanId;
	
	private String loanType;
	
	private int duration;

	private Date card_issue_date; 
	
	public UserLoan(int loanId, String loanType, int duration, Date card_issue_date) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.duration = duration;
		this.card_issue_date = card_issue_date;
	}
	
	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getCard_issue_date() {
		return card_issue_date;
	}

	public void setCard_issue_date(Date card_issue_date) {
		this.card_issue_date = card_issue_date;
	}

}

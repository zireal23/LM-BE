package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class IssueItem {
	private int issue_id;
	
	private String itemDescription;
	
	private char itemStatus;
	
	private String itemMake;
	
	private String itemCategory;
	
	private int itemValuation;
	
	public IssueItem(int issue_id, String itemDescription, char itemStatus, String itemMake, String itemCategory,
			int itemValuation) {
		super();
		this.issue_id = issue_id;
		this.itemDescription = itemDescription;
		this.itemStatus = itemStatus;
		this.itemMake = itemMake;
		this.itemCategory = itemCategory;
		this.itemValuation = itemValuation;
	}
	
	public int getIssue_id() {
		return issue_id;
	}
	public void setIssue_id(int issue_id) {
		this.issue_id = issue_id;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public char getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(char itemStatus) {
		this.itemStatus = itemStatus;
	}
	public String getItemMake() {
		return itemMake;
	}
	public void setItemMake(String itemMake) {
		this.itemMake = itemMake;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public int getItemValuation() {
		return itemValuation;
	}
	public void setItemValuation(int itemValuation) {
		this.itemValuation = itemValuation;
	}
}

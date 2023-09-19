package com.example.demo.model;

public class LoanApply {
	private String employeeID;
	
	private String itemCategory;
	
	private String itemDescription;
	
	private int itemValuation;
	
	private String itemMake;

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemValuation() {
		return itemValuation;
	}

	public void setItemValuation(int itemValuation) {
		this.itemValuation = itemValuation;
	}

	public String getItemMake() {
		return itemMake;
	}

	public void setItemMake(String itemMake) {
		this.itemMake = itemMake;
	}

	public LoanApply(String employeeID, String itemCategory, String itemDescription, int itemValuation, String itemMake) {
		this.employeeID = employeeID;
		this.itemCategory = itemCategory;
		this.itemDescription = itemDescription;
		this.itemValuation = itemValuation;
		this.itemMake = itemMake;
	}
}

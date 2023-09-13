package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Item {
	@Id
	@Column(name = "item_id", length = 20, nullable = false)
	private int itemId;
	@Column(name = "item_description", length = 40)
	private String itemDescription;
	@Column(name = "item_status", nullable = false)
	private char itemStatus;
	@Column(name = "item_make", length = 40)
	private String itemMake;
	@Column(name = "item_category", length = 20)
	private String itemCategory;
	@Column(name = "item_valuation", length = 10)
	private int itemValuation;
	
	@OneToMany(mappedBy = "item", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<EmployeeIssueDetails> employeeissue;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemMake() {
		return itemMake;
	}
	public void setItemMake(String itemMake) {
		this.itemMake = itemMake;
	}
	public char getItemStatus()
	{
		return itemStatus;
	}
	public void setItemStatus(char itemStatus)
	{
		this.itemStatus=itemStatus;
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

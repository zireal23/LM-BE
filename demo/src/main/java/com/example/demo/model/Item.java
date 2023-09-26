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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Item {


	@Id
	@Column(name = "item_id", length = 20, nullable = false)
	@PositiveOrZero // Ensures that itemId is a positive or zero value
	private int itemId;

	@Column(name = "item_description", length = 40)
	@Size(max = 40) // Limits the maximum length of itemDescription to 40 characters
	private String itemDescription;

	@Column(name = "item_status", nullable = false)
	@NotBlank // Ensures that itemStatus is not blank (not an empty string)
	private char itemStatus;

	@Column(name = "item_make", length = 40)
	@Size(max = 40) // Limits the maximum length of itemMake to 40 characters
	private String itemMake;

	@Column(name = "item_category", length = 20)
	@Size(max = 20) // Limits the maximum length of itemCategory to 20 characters
	private String itemCategory;

	@Column(name = "item_valuation")
	@PositiveOrZero // Ensures that itemValuation is a positive or zero value
	private int itemValuation;

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<EmployeeIssueDetails> employeeissue;

	public Item(int itemId, String itemDescription, char itemStatus, String itemMake, String itemCategory, int itemValuation) {
		this.itemId = itemId;
		this.itemDescription = itemDescription;
		this.itemStatus = itemStatus;
		this.itemMake = itemMake;
		this.itemCategory = itemCategory;
		this.itemValuation = itemValuation;
	}

	public Item() {
	}

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

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.IssueItem;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemMasterRepository;

import javax.persistence.NoResultException;

@Service
public class ItemMasterService {
	@Autowired
	ItemMasterRepository itemMasterRepo;
	
	public String saveItem(Item i) {
		String result="";
	
		Item obj = null;
		Optional<Item> optional = itemMasterRepo.findById(i.getItemId());
		if(optional.isPresent())
		{

			result="Item already exists";

			
		}
		else
		{
			try{
				obj = itemMasterRepo.save(i);
				result="Item saved";
			}
			catch(IllegalArgumentException Exception){
				result="Item not saved";
			}

		
		}
		return result;
	}
	public List<Item> getAllItems()
	{
		
		return itemMasterRepo.findAll();
	}
	public  Item getItemById(int ino)
	{
		
		return itemMasterRepo.findById(ino).get();
	}
	public List<String> getItemMakeFromCategory(String category){
		List<String> itemMakes = itemMasterRepo.getItemMakeFromCategory(category);
		return itemMakes;
	}
	public List<Item> getItemFromCategoryAndMake(String category, String make){
		List<Item> items = itemMasterRepo.getItemFromCategoryAndMake(category, make);

		return items;
	}
	
	public List<IssueItem> getAllItemsOfUser(String employeeId){
		List<IssueItem> itemsOfUser = itemMasterRepo.findItemsByEmployeeId(employeeId);

		return itemsOfUser;
	}
	
	public String editItem(Item l) {
		String result="";
		
		Item obj = null;
		Optional<Item> optional = itemMasterRepo.findById(l.getItemId());
		try{
			obj = itemMasterRepo.save(l);
			result = "Loan saved successfully";
		}
		catch (IllegalArgumentException Exception){
			result = "Loan not saved";
		}

		return result;
	}
	
	public String deleteItem(int l) {
		String result="";
		
		Item obj = null;
//		Optional<Loan> optional = loanRepo.findById(l.getLoanId());
		
		Optional<Item> optional = itemMasterRepo.findById(l);
		
		if(optional.isPresent()) {
			try{
				itemMasterRepo.deleteById(l);

			}
			catch(IllegalArgumentException Exception){
				result = "Item not deleted";
			}

		}
		else {
			result = "Unable to delete";
		}
		return result;
	}
}


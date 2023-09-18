package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.IssueItem;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemMasterRepository;

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
			result="Item exists";
			
		}
		else
		{
			obj = itemMasterRepo.save(i);
			if(obj!=null)
			result="Item saved";
			else
			result="Item saving failed";
		
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
		return itemMasterRepo.getItemMakeFromCategory(category);
	}
	public List<Item> getItemFromCategoryAndMake(String category, String make){
		return itemMasterRepo.getItemFromCategoryAndMake(category, make);
	}
	
	public List<IssueItem> getAllItemsofUser(String employeeId){
		return itemMasterRepo.findItemsByEmployeeId(employeeId);
	}
}


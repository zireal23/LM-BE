package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Item;


public interface ItemMasterRepository extends JpaRepository<Item, Integer> {
	
	@Query("SELECT DISTINCT i.itemMake FROM Item i WHERE i.itemCategory=?1")
	public List<String> getItemMakeFromCategory(String category);
	
	@Query("SELECT i FROM Item i WHERE i.itemCategory=?1 AND i.itemMake=?2")
	public List<Item> getItemFromCategoryAndMake(String category, String make);
	
	@Query("Select i from Item i where i.itemCategory=?1 and i.itemDescription=?2 and i.itemValuation=?3 and i.itemMake=?4")
	public Item findItemFromCategoryMakeDescriptionValue(String category,String desc,int value,String itemmake);
}


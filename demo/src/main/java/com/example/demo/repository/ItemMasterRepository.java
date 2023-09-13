package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Item;


public interface ItemMasterRepository extends JpaRepository<Item, Integer> {
	
	@Query("SELECT DISTINCT i.itemMake FROM Item i WHERE i.itemCategory=?1")
	public List<String> getItemMakeFromCategory(String categorty);
	
	@Query("SELECT i FROM Item i WHERE i.itemCategory=?1 AND i.itemMake=?2")
	public List<Item> getItemFromCategoryAndMake(String category, String make);
}


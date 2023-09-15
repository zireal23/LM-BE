package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Item;


public interface ItemMasterRepository extends JpaRepository<Item, Integer> {
	
	@Query("SELECT DISTINCT i.itemMake FROM Item i WHERE i.itemCategory=?1")
	public List<String> getItemMakeFromCategory(String category);
	
	@Query("SELECT i FROM Item i WHERE i.itemCategory=?1 AND i.itemMake=?2")
	public List<Item> getItemFromCategoryAndMake(String category, String make);
	
//	@Query("Select i from Item i where i.itemCategory=?1 and i.itemDescription=?2 and i.itemValuation=?3 and i.itemMake=?4")
	 @Query("SELECT i FROM Item i " +
	           "WHERE i.itemCategory = :itemCategory " +
	           "AND i.itemDescription = :itemDescription " +
	           "AND i.itemValuation = :itemValuation " +
	           "AND i.itemMake = :itemMake")
	public Item findItemFromCategoryMakeDescriptionValue(@Param("itemCategory") String itemCategory,
            @Param("itemDescription") String itemDescription,
            @Param("itemValuation") int itemValuation,
            @Param("itemMake") String itemMake);
}


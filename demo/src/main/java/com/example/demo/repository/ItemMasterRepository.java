package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.IssueItem;
import com.example.demo.model.Item;
import com.example.demo.model.Loan;
import com.example.demo.model.SELECT;


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
	 
	 @Query("SELECT distinct new com.example.demo.model.IssueItem(eid.issue_id, i.itemDescription, i.itemStatus, i.itemMake, i.itemCategory, i.itemValuation) " + 
			 	"FROM Item i " +
	           "INNER JOIN EmployeeIssueDetails eid ON i.itemId = eid.item.itemId " +
	           "INNER JOIN Employee emp ON eid.employee.employeeId = emp.employeeId " +
	           "WHERE eid.employee.employeeId = :employeeId")
	    List<IssueItem> findItemsByEmployeeId(@Param("employeeId") String employeeId);
}


package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.model.Loan;
import com.example.demo.service.ItemMasterService;
import com.example.demo.service.LoanService;

@RestController
@CrossOrigin("*")
public class ItemMasterController{
	@Autowired
	private ItemMasterService itemMasterService;

	@GetMapping("/showItem")
	public String showMessage() {
		return "Welcome";
	}
	
	@PostMapping("/saveItem")
	public String saveItem(@RequestBody Item i) {
		String result = "";
		result = itemMasterService.saveItem(i);
	//	System.out.println(i.getLoanType());
	/*	if(obj != null) {
			result = "User data saved";
		}
		else {
			result = "Insertion failed";
		}*/
		
		return result;
	}
	@GetMapping("/fetchItems")
	public List<Item> getAllItems()
	{
		return itemMasterService.getAllItems();
	}
	
	@GetMapping("/fetchItemMake")
	@ResponseBody
	public List<String> getItemMake(@RequestParam String category){
		return itemMasterService.getItemMakeFromCategory(category);
	}
	
	@GetMapping("/fetchItemById/{ItemId}")
	public Item getItemById(@PathVariable("itemId")  int ino)
	{
		return itemMasterService.getItemById(ino);
	}
	
	@GetMapping("/fetchItemsFromCategoryAndMake")
	@ResponseBody
	public List<Item> getItems(@RequestParam String category, @RequestParam String make){
		return itemMasterService.getItemFromCategoryAndMake(category, make);
	}
	
	@GetMapping("/fetchItemsofUser")
	public List<Item> getAllItems(@RequestParam String employeeId)
	{
		return itemMasterService.getAllItemsofUser(employeeId);
	}
	
//    @PutMapping("/updateStudent/{rno}")
//    public ResponseEntity<Student> updateStudent(@PathVariable("rno") int regno, @Valid @RequestBody Student stud) {
//
//       
//        Student studObj = studService.getStudentById(regno);
//
//        if (studObj != null) {
//        
//            studObj.setName(stud.getName());
//            studObj.setDepartment(stud.getDepartment());
//            return new ResponseEntity<>(studService.saveStudent(studObj), HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

	
}



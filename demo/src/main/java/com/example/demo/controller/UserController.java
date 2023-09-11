package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController{
	@Autowired
	private UserService userService;

	@GetMapping("/showMessage")
	public String showMessage() {
		return "Welcome";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody User u) {
		String result = "";
		result = userService.saveUser(u);
	/*	if(obj != null) {
			result = "User data saved";
		}
		else {
			result = "Insertion failed";
		}*/
		
		return result;
	}
	
}


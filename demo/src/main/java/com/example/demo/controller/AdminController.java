package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.service.AdminService;

@RestController
@CrossOrigin("*")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@PostMapping("/loginadmin")
	public String login(@RequestBody Login l) {
		String result = "";
		
		result = adminService.loginAdmin(l);
		System.out.println(result);
		return result;
	}
	
	
}

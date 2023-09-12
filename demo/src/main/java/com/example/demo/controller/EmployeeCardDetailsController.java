package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeCardDetails;
import com.example.demo.service.EmployeeCardDetailsService;


@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeCardDetailsController {
	@Autowired
	private EmployeeCardDetailsService detailsService;
	
	@PostMapping("/saveEmployeeCardDetails")
	public String saveEmployeeCardDetails(@RequestBody EmployeeCardDetails details) {
		String result = "";
		result = detailsService.saveEmployeeCardDetails(details);
		
		
		return result;
	}
	
}

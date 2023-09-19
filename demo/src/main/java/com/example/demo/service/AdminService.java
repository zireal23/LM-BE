package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepo;
	
	public String loginAdmin(Login l) {
		String result = "";
		Employee e = null;
		Optional<Employee> optional = adminRepo.findById(l.getEmployeeId());
		if(optional.isPresent()) {
			e = optional.get();
//			e.setEmployeeId(l.getUsername());
			
				if(e.getPassword().equals(l.getPassword()) && e.getIsAdmin().equals("Yes")) {
					result = "Login Successful";
				}
				else {
					result = "Login failed";
				}
			}
			
		
		else {
			result = " Login failed, user doesn't exist";
		}
		return result;
	}
}

package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService{
	
	@Autowired
	UserRepository userRepo;
	
	public String saveUser(User u) {
		String result="";
	
		User obj = null;
		Optional<User> optional = userRepo.findById(u.getId());
		System.out.println(optional.get());
		if(optional.isPresent())
		{
		result="User is existing";
		}
		else
		{
			obj = userRepo.save(u);
			if(obj!=null)
			result="User saved";
			else
			result="Registration failed";
		
		}
		return result;
	}
	
}
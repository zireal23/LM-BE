package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeCardDetails;
import com.example.demo.repository.EmployeeCardDetailsRepository;

@Service
public class EmployeeCardDetailsService {

	@Autowired
	EmployeeCardDetailsRepository detailsRepo;
	
	public String saveEmployeeCardDetails(EmployeeCardDetails card) {
		String result = "";
		EmployeeCardDetails obj = null;
		Optional<EmployeeCardDetails> optional = detailsRepo.findById(card.getId());
		if(optional.isPresent()) {
			result="Employee card is existing";
		}
		else {
			try{
				obj = detailsRepo.save(card);
				result = "Employee Card Details Saved";
			}
			catch (IllegalArgumentException exception){
				result="Employee Card Details not Saved";
			}


		}
		
		return result;
	}
}

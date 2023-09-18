package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Loan;
import com.example.demo.model.UserLoan;
import com.example.demo.repository.LoanRepository;
@Service
public class LoanService {
	@Autowired
	LoanRepository loanRepo;
	
	public String saveLoan(Loan l) {
		String result="";
	
		Loan obj = null;
		Optional<Loan> optional = loanRepo.findById(l.getLoanId());
		if(optional.isPresent())
		{
			result="User is existing";
			
		}
		else
		{
			obj = loanRepo.save(l);
			if(obj!=null)
			result="User saved";
			else
			result="Registration failed";
		
		}
		return result;
	}
	public List<Loan> getAllLoans()
	{
		
		return loanRepo.findAll();
	}
	
	public List<UserLoan> getAllLoansofUser(String employeeId){
		return loanRepo.findLoansByEmployeeId(employeeId);
	}
	
	public Loan getLoanById(int lno)
	{
		
		return loanRepo.findById(lno).get();
	}
	public List<String> getDistinctLoanTypes(){
		return loanRepo.getDistinctLoanTypes();
	}
	
	public String editLoan(Loan l) {
		String result="";
		
		Loan obj = null;
		Optional<Loan> optional = loanRepo.findById(l.getLoanId());
		obj = loanRepo.save(l);
		result = "Loan saved successfully";
		return result;
	}
	
	public String deleteLoan(int l) {
		String result="";
		
		Loan obj = null;
//		Optional<Loan> optional = loanRepo.findById(l.getLoanId());
		
		Optional<Loan> optional = loanRepo.findById(l);
		
		if(optional.isPresent()) {
			loanRepo.deleteById(l);
			result = "Loan deleted successfully";
		}
		else {
			result = "Unable to delete";
		}
		return result;
	}
	
	
	
	
}


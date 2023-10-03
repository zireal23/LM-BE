package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Loan;
import com.example.demo.model.UserLoan;
import com.example.demo.repository.LoanRepository;

import javax.persistence.NoResultException;

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
			result="Loan exists";
			
		}
		else
		{
			try{
				obj = loanRepo.save(l);
				result="Loan saved";
			}
			catch(IllegalArgumentException Exception){
				result="Loan not saved";
			}

		
		}
		return result;
	}
	public List<Loan> getAllLoans()
	{
		List<Loan> loans = loanRepo.findAll();
//		if(loans.isEmpty()) {
//			System.out.println("Array empty");
//			throw new NoResultException();
//		}
			
		return loans;
	}
	
	public List<UserLoan> getAllLoansofUser(String employeeId){
		List<UserLoan> loans = loanRepo.findLoansByEmployeeId(employeeId);
//		if(loans.isEmpty())
//			throw new NoResultException();
		return loans;
	}
	
	public Loan getLoanById(int lno)
	{
		
		return loanRepo.findById(lno).get();
	}
	public List<String> getDistinctLoanTypes(){
		List<String> loanTypes = loanRepo.getDistinctLoanTypes();
//		if(loanTypes.isEmpty())
//			throw new NoResultException();
		return loanTypes;
	}
	
	public String editLoan(Loan l) {
		String result="";
		
		Loan obj = null;
		Optional<Loan> optional = loanRepo.findById(l.getLoanId());
		try{
			obj = loanRepo.save(l);
			result="Loan updated";
		}
		catch(IllegalArgumentException Exception){
			result="Loan not updated";
		}
		return result;
	}
	
	public String deleteLoan(int l) {
		String result="";
		
		Loan obj = null;
//		Optional<Loan> optional = loanRepo.findById(l.getLoanId());
		
		Optional<Loan> optional = loanRepo.findById(l);
		
		if(optional.isPresent()) {
			try{
				loanRepo.deleteById(l);
				result = "Loan deleted successfully";
			}
			catch(IllegalArgumentException Exception){
				result = "Loan not deleted";
			}

		}
		else {
			result = "Unable to delete";
		}
		return result;
	}
	
	
	
	
}


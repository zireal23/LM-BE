package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
	@Query("Select l.loanType from Loan l")
	public List<String> getDistinctLoanTypes();
}


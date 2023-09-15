package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
	@Query("Select l.loanType from Loan l")
	public List<String> getDistinctLoanTypes();
	
	@Query("Select l from Loan l where l.loanType=?1")
	public Loan getLoanFromLoanType(String category);
	
	 @Query("SELECT distinct lc FROM Loan lc " +
	           "INNER JOIN EmployeeCardDetails ecd ON lc.loanId = ecd.loan.loanId " +
	           "WHERE ecd.employee.employeeId = :employeeId")
	    List<Loan> findLoansByEmployeeId(@Param("employeeId") String employeeId);
}


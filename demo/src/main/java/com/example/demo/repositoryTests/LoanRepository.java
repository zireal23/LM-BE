package com.example.demo.repositoryTests;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Loan;
import com.example.demo.model.UserLoan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
	@Query("Select l.loanType from Loan l")
	public List<String> getDistinctLoanTypes();
	
	@Query("Select l from Loan l where l.loanType=?1")
	public Loan getLoanFromLoanType(String category);
	
	@Query("SELECT distinct new com.example.demo.model.UserLoan(lc.loanId, lc.loanType, lc.duration, ecd.card_issue_date) " +
	           "FROM Loan lc " +
	           "INNER JOIN EmployeeCardDetails ecd ON lc.loanId = ecd.loan.loanId " +
	           "INNER JOIN Employee emp ON ecd.employee.employeeId = emp.employeeId " +
	           "WHERE ecd.employee.employeeId = :employeeId")
	public List<UserLoan> findLoansByEmployeeId(@Param("employeeId") String employeeId);
}


package com.example.demo.repository;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;

//import java.sql.Date;

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
	
	@Query("SELECT DISTINCT new com.example.demo.model.UserLoan(lc.loanId, lc.loanType, lc.duration, eid.issueDate) " +
	           "FROM Loan lc " +
	           "INNER JOIN EmployeeCardDetails ecd ON lc.loanId = ecd.loan.loanId " +
	           "INNER JOIN EmployeeIssueDetails eid ON ecd.employee.employeeId = eid.employee.employeeId " +
	           "WHERE eid.employee.employeeId = :employeeId " +
	           "AND eid.returnDate > CURRENT_DATE ")
	public List<UserLoan> findLoansByEmployeeId(@Param("employeeId") String employeeId);
}


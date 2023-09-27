package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeCardDetails;
import com.example.demo.model.EmployeeIssueDetails;
import com.example.demo.model.Item;
import com.example.demo.model.Loan;
import com.example.demo.model.LoanApply;
import com.example.demo.repository.EmployeeCardDetailsRepository;
import com.example.demo.repository.EmployeeIssueDetailsRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ItemMasterRepository;
import com.example.demo.repository.LoanRepository;

@Service
public class EmployeeLoanService {
	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	EmployeeCardDetailsRepository empCardRepo;

	@Autowired
	LoanRepository loanRepo;

	@Autowired
	ItemMasterRepository itemRepo;

	@Autowired
	EmployeeIssueDetailsRepository empIssueDetailsRepo;

	// Inserts loan application data in employee card details table and employee
	// issue table
	@Transactional
	public String insertLoanApplicationData(LoanApply application) {
		String resultString = "";
		EmployeeCardDetails cardDetails = new EmployeeCardDetails();
		Employee employee = empRepo.findById(application.getEmployeeID()).get();
		Loan loan = loanRepo.getLoanFromLoanType(application.getItemCategory());
		Date cardIssueDate = Date.valueOf(LocalDate.now());
		cardDetails.setCard_issue_date(cardIssueDate);
		cardDetails.setEmployee(employee);
		cardDetails.setLoan(loan);

		EmployeeCardDetails cardResponseFromSaveProcedure = empCardRepo.save(cardDetails);
		// Need better exception handling here
        System.out.println("Employee Card Details saved");
        resultString = "card Saved";
        EmployeeIssueDetails issueDetails = new EmployeeIssueDetails();
		int loanDuration = loan.getDuration();
		// Need to get rid of the legacy java.sql.date type
		// Using this because then will need to drop the table and insert dummy data
		// again
		// I am lazy :/
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(cardIssueDate);
		calendar.add(Calendar.YEAR, loanDuration);
		Date returnDate = new Date(calendar.getTimeInMillis());
		Item issuedItem = itemRepo.findItemFromCategoryMakeDescriptionValue(application.getItemCategory(),
						application.getItemDescription(), application.getItemValuation(), application.getItemMake());
		issueDetails.setEmployee(employee);
		issueDetails.setIssueDate(cardIssueDate);
		issueDetails.setItem(issuedItem);
		issueDetails.setReturnDate(returnDate);

		EmployeeIssueDetails issueDetailsResponseFromSaveProcedure = empIssueDetailsRepo.save(issueDetails);

        resultString += " " + "Item Issue Details saved";

        return resultString;
	}
}

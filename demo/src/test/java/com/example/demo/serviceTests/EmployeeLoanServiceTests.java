package com.example.demo.serviceTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.model.Item;
import com.example.demo.model.Loan;
import com.example.demo.model.LoanApply;
import com.example.demo.repository.*;
import com.example.demo.service.EmployeeLoanService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

public class EmployeeLoanServiceTests {

    @InjectMocks
    private EmployeeLoanService employeeLoanService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private LoanRepository loanRepository;

    @Mock
    private EmployeeCardDetailsRepository employeeCardDetailsRepository;

    @Mock
    private EmployeeIssueDetailsRepository employeeIssueDetailsRepository;

    @Mock
    private ItemMasterRepository itemRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void applyForLoan() {
        // Define some sample data
        LoanApply employeeLoan = new LoanApply("123", "furniture","chair",30,"wooden");
        Employee employee = new Employee("123","Asif","Program Associate","GG","M", Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()),"GG");
        Loan loan = new Loan(11,"furniture", 3);
        Item item = new Item(123,"chair",'Y',"wooden","furniture",30);

        // Mock repository behaviors
        when(employeeRepository.findById("123")).thenReturn(Optional.of(employee));
        when(loanRepository.getLoanFromLoanType("furniture")).thenReturn(loan);
        when(loanRepository.findById(11)).thenReturn(Optional.of(loan));
        when(itemRepository.findItemFromCategoryMakeDescriptionValue("furniture","chair",30,"wooden")).thenReturn(item);

        // Call the service method
        String result = employeeLoanService.insertLoanApplicationData(employeeLoan);

        System.out.println(result);

        // Assert that the result is as expected
        assertEquals("Card table updated Issue Table updated", result);
    }
}

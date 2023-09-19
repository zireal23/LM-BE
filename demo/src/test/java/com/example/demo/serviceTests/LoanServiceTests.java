package com.example.demo.serviceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Loan;
import com.example.demo.repository.LoanRepository;
import com.example.demo.service.LoanService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class LoanServiceTests {

    @Mock
    LoanRepository loanRepository;

    @InjectMocks
    LoanService loanService;

    private Loan loan;

    @BeforeEach
    void setUp() {
        Loan loan = new Loan();
        loan.setLoanId(1234);
        loan.setDuration(4);
        loan.setLoanType("Furniture");
        this.loan = loan;
    }


    //JUnit test for saveLoan method
    @Test
    void saveLoan() {

        when(loanRepository.save(loan)).thenReturn(loan);

        String savedLoan=loanService.saveLoan(loan);

        Assertions.assertEquals(savedLoan, "Loan saved");

    }

    //JUnit test for getLoanList method
    @Test
    void getLoanList() {

        when(loanRepository.findAll()).thenReturn(List.of(loan));

        List<Loan> loanList = loanService.getAllLoans();

        assertThat(loanList).isNotNull();

        assertThat(loanList.size()).isEqualTo(1);

    }

    @Test
    void getLoanById() {

        when(loanRepository.findById(1234)).thenReturn(Optional.of(loan));

        Loan loanById=loanService.getLoanById(1234);

        assertThat(loanById).isNotNull();

    }

//    @Test
//    public void deleteLoanById() {
//        // Define some sample data
//        String loanId = "123";
//
//        // Mock the repository behavior to simulate a successful delete
//        when(loanRepository.findById(loanId)).thenReturn(Optional.of(new Loan()));
//
//        // Call the service method
//        String result = loanService.deleteLoanById(loanId);
//
//        // Assert that the result indicates success
//        assertEquals("Loan deleted successfully", result);
//    }

    @Test
    void getDistinctLoanType() {

        List<String> expectedDistinctLoanTypes = Arrays.asList("Home Loan", "Car Loan", "Personal Loan");

        when(loanRepository.getDistinctLoanTypes()).thenReturn(expectedDistinctLoanTypes);

        List<String> listOfLoanTypes = loanService.getDistinctLoanTypes();

        assertThat(listOfLoanTypes).isNotNull();
        assertEquals(expectedDistinctLoanTypes,listOfLoanTypes);
    }

}
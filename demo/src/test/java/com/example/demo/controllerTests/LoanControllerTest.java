package com.example.demo.controllerTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import com.example.demo.controller.LoanController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.Loan;
import com.example.demo.service.LoanService;
import com.fasterxml.jackson.databind.ObjectMapper;

// Import other necessary classes...

@WebMvcTest(LoanController.class)
public class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoanService loanService;

    @MockBean
    private LoanController loanController;

    @Autowired
    private ObjectMapper objectMapper; // ObjectMapper for JSON serialization/deserialization

    @Test
    public void testSaveLoan() throws Exception {
        // Create a sample loan to save
        Loan loanToSave = new Loan();
        loanToSave.setLoanType("Personal Loan");

        // Define the expected saved loan with an ID
        Loan savedLoan = new Loan();
        savedLoan.setLoanId(1011);
        savedLoan.setLoanType("Personal Loan");

        // Mock the behavior of loanService.saveLoan
        when(loanService.saveLoan(any(Loan.class))).thenReturn("Loan saved");

        // Perform a POST request to /loan with JSON content
        mockMvc.perform(post("/saveLoan")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(loanToSave)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetLoanList() throws Exception {
        // Define a list of sample loans for the expected response
        List<Loan> expectedLoans = Arrays.asList(
                new Loan(1, "Personal Loan", 10),
                new Loan(2, "Home Loan", 15)
        );

        // Mock the behavior of loanService.getAllLoans
        when(loanService.getAllLoans()).thenReturn(expectedLoans);

        // Perform a GET request to /loan
        mockMvc.perform(get("/fetchAllLoans"))
                .andExpect(status().isOk());
    }


    @Test
    public void testGetDistinctLoanTypes() throws Exception {
        // Define a list of sample distinct loan types for the expected response
        List<String> expectedLoanTypes = Arrays.asList("Personal Loan", "Home Loan");

        // Mock the behavior of loanService.getDistinctLoanTypes
        when(loanService.getDistinctLoanTypes()).thenReturn(expectedLoanTypes);

        // Perform a GET request to /loan/distinctLoanTypes
        mockMvc.perform(get("/distinctLoanTypes"))
                .andExpect(status().isOk());
    }
}

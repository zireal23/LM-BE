package com.example.demo.controller;

import com.example.demo.controller.EmployeeController; // Import your controller class
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeCardDetails; // Import your entity class
import com.example.demo.model.Loan;
import com.example.demo.service.EmployeeCardDetailsService;
import com.example.demo.service.EmployeeService; // Import your service class
import com.fasterxml.jackson.databind.ObjectMapper; // Import ObjectMapper for JSON serialization
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Date;
import java.time.LocalDate;

@WebMvcTest(EmployeeController.class) // Replace with your actual controller class
@ExtendWith(SpringExtension.class)
public class EmployeeCardDetailsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeCardDetailsService employeeCardDetailsService; // Mock your service class

    @Autowired
    private ObjectMapper objectMapper; // ObjectMapper for JSON serialization

    @Test
    public void testSaveEmployeeCardDetails() throws Exception {
        // Create a sample EmployeeCardDetails object
        EmployeeCardDetails employeeCardDetails = new EmployeeCardDetails();
        employeeCardDetails.setId(1); // Set the ID if necessary
        employeeCardDetails.setEmployee(new Employee()); // Create a sample Employee object or mock it
        employeeCardDetails.setLoan(new Loan()); // Create a sample Loan object or mock it
        employeeCardDetails.setCard_issue_date(Date.valueOf(LocalDate.now())); // Set the card issue date

        // Convert the EmployeeCardDetails object to JSON
        String employeeCardDetailsJson = objectMapper.writeValueAsString(employeeCardDetails);

        // Mock the behavior of your service method
        Mockito.when(employeeCardDetailsService.saveEmployeeCardDetails(Mockito.any(EmployeeCardDetails.class))).thenReturn("Card details saved");

        // Perform a POST request to the "/saveEmployeeCardDetails" endpoint
        mockMvc.perform(MockMvcRequestBuilders.post("/saveEmployeeCardDetails")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeCardDetailsJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Card details saved"));
    }
}

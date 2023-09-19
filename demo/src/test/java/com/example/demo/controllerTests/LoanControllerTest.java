package com.example.demo.controllerTests;

import org.junit.jupiter.api.Test;

import com.example.demo.controller.EmployeeController;
import com.example.demo.controller.LoanController;
import com.example.demo.model.Employee;
import com.example.demo.model.Loan;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.LoanService;
import org.junit.jupiter.api.BeforeEach;
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

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(EmployeeController.class)
@ExtendWith(SpringExtension.class)
public class LoanControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private LoanService loanService;
	
    private Validator validator;
    
    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	
	@Test
	void testSaveLoans() throws Exception{
		Loan loan = new Loan();
		loan.setLoanId(1001);
		loan.setLoanType("Furniture");
		loan.setDuration(2);
		
		Mockito.when(loanService.saveLoan(Mockito.any(Loan.class))).thenReturn("Loan details Saved");
        // Perform the POST request to save the employee
        mockMvc.perform(MockMvcRequestBuilders.post("/saveLoan")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"loanId\":\"1001\",\"loanType\":\"Furniture\",\"duration\":\"2\"}")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Loan Data Saved"));
    
	}
	
	@Test
    public void testInvalidLoanCard() throws Exception {
        // Create an invalid employee instance (missing required fields)
        Loan loan = new Loan();

        // Validate the employee
        Set<ConstraintViolation<Loan>> violations = validator.validate(loan);

        // Ensure there are validation errors
        assertFalse(violations.isEmpty());

        // Perform the POST request to save the employee (should fail due to validation)
        mockMvc.perform(MockMvcRequestBuilders.post("/saveEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"loanId\":\"\",\"duration\":\"\",\"loanType\":\"\"}")
        )
                .andExpect(MockMvcResultMatchers.status().isBadRequest()); // Expect a 400 Bad Request
    }

}

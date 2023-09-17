package com.example.demo.test;


import com.example.demo.controller.EmployeeController;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
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
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testGetValidEmployee() throws Exception {
        // Create a valid employee instance
        Employee employee = new Employee();
        employee.setEmployeeId("RS101");
        employee.setEmployeeName("xyz");
        employee.setDesignation("programmer");
        employee.setDepartment("cse");
        employee.setGender("m");
        employee.setDateofjoining(Date.valueOf("2023-09-07"));
        employee.setDateofbirth(Date.valueOf("2002-04-15"));
        employee.setPassword("1234");
 
//        String allEmployees;
//		allEmployees.add(employee);
        // Validate the employee
        //Set<javax.validation.ConstraintViolation<Employee>> violations = validator.validate(employee);

        // Ensure there are no validation errors
        //assertTrue(violations.isEmpty());

        // Mock the service behavior
        //Mockito.when(employeeService.saveEmployee(employee)).thenReturn("User Saved");
        Mockito.when(employeeService.saveEmployee(Mockito.any(Employee.class))).thenReturn("User Saved");

        // Perform the POST request to save the employee
        mockMvc.perform(MockMvcRequestBuilders.post("/saveEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"employeeId\":\"RS101\",\"employeeName\":\"xyz\",\"designation\":\"programmer\",\"department\":\"cse\",\"gender\":\"m\",\"dateofjoining\":\"2023-09-07\",\"dateofbirth\":\"2002-04-15\",\"password\":\"1234\"}")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("User Saved"));
    }

    @Test
    public void testSaveInvalidEmployee() throws Exception {
        // Create an invalid employee instance (missing required fields)
        Employee employee = new Employee();

        // Validate the employee
        Set<javax.validation.ConstraintViolation<Employee>> violations = validator.validate(employee);

        // Ensure there are validation errors
        assertFalse(violations.isEmpty());

        // Perform the POST request to save the employee (should fail due to validation)
        mockMvc.perform(MockMvcRequestBuilders.post("/saveEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"employeeId\":\"\",\"employeeName\":\"\",\"designation\":\"\",\"department\":\"\",\"gender\":\"\",\"dateofjoining\":\"\",\"dateofbirth\":\"\",\"password\":\"\"}")
        )
                .andExpect(MockMvcResultMatchers.status().isBadRequest()); // Expect a 400 Bad Request
    }
}

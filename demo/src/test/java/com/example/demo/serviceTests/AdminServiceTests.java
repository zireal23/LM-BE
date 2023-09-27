package com.example.demo.serviceTests;

import com.example.demo.model.Admin;
import com.example.demo.model.Employee;
import com.example.demo.model.Login;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTests {

	 @InjectMocks
	    private AdminService adminService;

	    @Mock
	    private AdminRepository adminRepository;

	    @Test
	    public void testLoginAdminSuccess() {
	        // Create a Login object
	    	

	    	// Create a Login object
	        Login login = new Login();
	        login.setemployeeId("AD101"); // Set the correct field name
	        login.setPassword("123456");

	        // Create a mock Employee
	        Employee employee = new Employee();
	        employee.setEmployeeId("AD101"); // Set the correct field name
	        employee.setPassword("123456");
	        employee.setIsAdmin("Yes");

	        // Mock the behavior of the AdminRepository
	        Mockito.when(adminRepository.findById("AD101")).thenReturn(Optional.of(employee));

	        // Test the loginAdmin method
	        String result = adminService.loginAdmin(login);

	        // Ensure that login failed due to incorrect password
	        assertEquals("Login Successful", result);
	    }

	    @Test
	    public void testLoginAdminFailureIncorrectPassword() {
	    	// Create a Login object
	        Login login = new Login();
	        login.setemployeeId("AD101"); // Set the correct field name
	        login.setPassword("incorrectPassword");

	        // Create a mock Employee
	        Employee employee = new Employee();
	        employee.setEmployeeId("AD101"); // Set the correct field name
	        employee.setPassword("123456");
	        employee.setIsAdmin("Yes");

	        // Mock the behavior of the AdminRepository
	        Mockito.when(adminRepository.findById("AD101")).thenReturn(Optional.of(employee));

	        // Test the loginAdmin method
	        String result = adminService.loginAdmin(login);

	        // Ensure that login failed due to incorrect password
	        assertEquals("Login failed", result);
	    }
}

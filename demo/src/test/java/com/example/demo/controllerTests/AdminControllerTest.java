package com.example.demo.controllerTests;

import com.example.demo.controller.AdminController;
import com.example.demo.model.Admin;
import com.example.demo.model.Login;
import com.example.demo.model.Employee;
import com.example.demo.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(AdminController.class)
@ExtendWith(SpringExtension.class)
public class AdminControllerTest {

	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private AdminService adminService;

	    @Test
	    public void testLoginAdmin() throws Exception {
	        // Create a Login object to use in the request
	        Admin admin = new Admin();
	        admin.setAdminId("admin");
	        admin.setPassword("admin_password");

	        // Mock the service behavior to return a result
	        Mockito.when(adminService.loginAdmin(Mockito.any(Login.class))).thenReturn("Login Successful");

	        // Perform a POST request to the /loginadmin endpoint
	        mockMvc.perform(MockMvcRequestBuilders.post("/loginadmin")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content("{\"username\":\"admin\",\"password\":\"admin_password\"}")
	        )
	                .andExpect(MockMvcResultMatchers.status().isOk()) // Expect HTTP 200 OK
	                .andExpect(MockMvcResultMatchers.content().string("Login Successful")); // Expect the response content to be "Login Successful"
	    }
}

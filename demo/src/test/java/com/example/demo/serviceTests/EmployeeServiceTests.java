package com.example.demo.serviceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;


    //JUnit test for save employee method
    @Test
    void saveEmployee() {

        Employee employee = new Employee();
        employee.setEmployeeId("RS101");
        employee.setEmployeeName("xyz");
        employee.setDesignation("programmer");
        employee.setDepartment("cse");
        employee.setGender("m");
        employee.setDateofjoining(Date.valueOf("2023-09-07"));
        employee.setDateofbirth(Date.valueOf("2002-04-15"));
        employee.setPassword("1234");
        //
        when(employeeRepository.save(employee)).thenReturn(employee);

        String result=employeeService.saveEmployee(employee);
        System.out.println(result);
        System.out.print(employee);
        Assertions.assertEquals(result, "User saved");
    }

    @Test
    void findEmployeeById() {
        Employee employee = new Employee();
        employee.setEmployeeId("RS101");
        employee.setEmployeeName("xyz");
        employee.setDesignation("programmer");
        employee.setDepartment("cse");
        employee.setGender("m");
        employee.setDateofjoining(Date.valueOf("2023-09-07"));
        employee.setDateofbirth(Date.valueOf("2002-04-15"));
        employee.setPassword("1234");
        when(employeeRepository.findById("RS101")).thenReturn(Optional.of(employee));

        System.out.println(employeeRepository);
        System.out.println(employeeService);

        Optional<Employee> fetchedEmployee=employeeService.getEmployeeByID("RS101");
        System.out.println(fetchedEmployee);
        assertThat(fetchedEmployee).isNotNull();
    }

//    @Test
//    public void deleteEmployeeById() {
//        // Define some sample data
//        String employeeId = "123";
//
//        // Mock the repository behavior to simulate a successful delete
//        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(new Employee()));
//
//        // Call the service method
//        String result = employeeService.deleteEmployeeById(employeeId);
//
//        // Assert that the result indicates success
//        assertEquals("Employee deleted successfully", result);
//    }

}
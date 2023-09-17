package com.example.demo.repository;

import java.util.Optional;
import com.example.demo.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.sql.Date;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    //Follows the Arrange-Act-Assert principle for testing
    //Can try other methods as well
    public void employeeRepositorySaveReturnsEmployee(){
        //Arrange the resources needed to execute the test
        Employee employee = new Employee();
        employee.setEmployeeId("RS101");
        employee.setEmployeeName("xyz");
        employee.setDesignation("programmer");
        employee.setDepartment("cse");
        employee.setGender("m");
        employee.setDateofjoining(Date.valueOf("2023-09-07"));
        employee.setDateofbirth(Date.valueOf("2002-04-15"));
        employee.setPassword("1234");


        //Act, save the employee to the mock database and Assert
        Assertions.assertDoesNotThrow(()->employeeRepository.save(employee));
    }

    @Test
    public void employeeRepositoryFindByIDReturnsEmployee(){
        //Arrange the resources needed to execute the test
        Employee employee = new Employee();
        employee.setEmployeeId("RS101");
        employee.setEmployeeName("xyz");
        employee.setDesignation("programmer");
        employee.setDepartment("cse");
        employee.setGender("m");
        employee.setDateofjoining(Date.valueOf("2023-09-07"));
        employee.setDateofbirth(Date.valueOf("2002-04-15"));
        employee.setPassword("1234");


        //Act, save the employee to the mock database and then find it
        Employee savedEmployee = employeeRepository.save(employee);
        Optional<Employee> foundEmployee = employeeRepository.findById(employee.getEmployeeId());

        //Assert
        Assertions.assertTrue(foundEmployee.isPresent());
    }

}

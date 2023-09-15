package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeCardDetails;
import com.example.demo.model.Loan;

@Repository
public interface EmployeeCardDetailsRepository extends JpaRepository<EmployeeCardDetails, Integer> {

}

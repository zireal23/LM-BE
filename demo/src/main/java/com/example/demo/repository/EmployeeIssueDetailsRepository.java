package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeIssueDetails;

@Repository
public interface EmployeeIssueDetailsRepository extends JpaRepository<EmployeeIssueDetails, Integer> {

}

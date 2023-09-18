package com.example.demo.repositoryTests;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeCardDetails;

@Repository
public interface EmployeeCardDetailsRepository extends JpaRepository<EmployeeCardDetails, Integer> {

}

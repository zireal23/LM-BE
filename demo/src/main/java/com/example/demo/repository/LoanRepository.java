package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {}


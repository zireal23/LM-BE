package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Item;


public interface ItemMasterRepository extends JpaRepository<Item, Integer> {}


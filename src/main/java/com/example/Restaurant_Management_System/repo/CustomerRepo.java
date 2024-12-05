package com.example.Restaurant_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Restaurant_Management_System.dto.Customer;

public interface CustomerRepo  extends JpaRepository<Customer , Integer>{

}

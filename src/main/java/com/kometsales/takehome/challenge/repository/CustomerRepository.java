package com.kometsales.takehome.challenge.repository;

import com.kometsales.takehome.challenge.model.Customer;
import com.kometsales.takehome.challenge.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

package com.JERZ.GroceryGurus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.JERZ.GroceryGurus.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

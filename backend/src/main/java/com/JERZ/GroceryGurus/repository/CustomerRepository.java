package com.JERZ.GroceryGurus.repository;

import com.JERZ.GroceryGurus.model.Customer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
   
}

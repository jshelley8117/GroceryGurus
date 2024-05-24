package com.JERZ.GroceryGurus.repository;
import com.JERZ.GroceryGurus.model.Customer;
import org.springframework.data.repository.CrudRepository;
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
   
}
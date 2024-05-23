package com.JERZ.GroceryGurus.controller;

import com.JERZ.GroceryGurus.repository.CustomerRepository;
import com.JERZ.GroceryGurus.model.Customer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // this sends an HTTP GET request to the server retrieve all Customers in our database
    @GetMapping("/customers")
    public Iterable<Customer> findAllCustomers() {
        return this.customerRepository.findAll();
    }

    // this sends an HTTP GET request to the server to retrieve an individual customer based on a customer ID in our database
    @GetMapping("/customers/{id}")
    public Optional<Customer> findCustomerByID(@PathVariable("id") Integer id) {
        return this.customerRepository.findById(id);
    }
    
    // this sends an HTTP POST request to the server to add a new customer to the database
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }

    // this sends an HTTP DELETE request to the server to delete a customer in our DB based on a given ID
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) {
        this.customerRepository.deleteById(id);
    }

    // this sends an HTTP PUT request to the server to update an existing customer in the database
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable("id") Integer id,
    @RequestBody Customer c) {
        Optional<Customer> customerToUpdateOptional = this.customerRepository.findById(id);
        if(!customerToUpdateOptional.isPresent()) return null;
        Customer customerToUpdate = customerToUpdateOptional.get();
        customerToUpdate.setEmail(c.getEmail());
        customerToUpdate.setFirst_name(c.getFirst_name());
        customerToUpdate.setLast_name(c.getLast_name());
        Customer updatedCustomer = this.customerRepository.save(customerToUpdate);
        return updatedCustomer;
    }
}

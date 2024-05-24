package com.JERZ.GroceryGurus.controller;

import com.JERZ.GroceryGurus.service.CustomerService;
import com.JERZ.GroceryGurus.model.Customer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) { this.customerService = customerService; }

    @GetMapping("/customers")
    public Iterable<Customer> getAllCustomers() { return this.customerService.findAllCustomers(); }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
        Optional<Customer> customer = this.customerService.findCustomerById(id);
        return (customer.isPresent()) ? ResponseEntity.ok(customer.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) { return this.customerService.createCustomer(customer); }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) { this.customerService.deleteCustomer(id); }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Integer id,
    @RequestBody Customer c) {
        Customer updatedCustomer = this.customerService.updateCustomer(id, c);
        return (updatedCustomer != null) ? ResponseEntity.ok(updatedCustomer) : ResponseEntity.notFound().build();
    }
}
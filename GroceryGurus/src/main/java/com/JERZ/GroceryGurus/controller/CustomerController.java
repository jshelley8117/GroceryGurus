package com.JERZ.GroceryGurus.controller;

import com.JERZ.GroceryGurus.entity.Customer;
import com.JERZ.GroceryGurus.service.CustomerService;    

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class CustomerController {
    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = this.customerService.findAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
        Customer customer = this.customerService.findById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer c) {
        this.customerService.create(c);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") Integer id) {
        Customer customer = this.customerService.findById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        this.customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable("id") Integer id, @RequestBody Customer c) {
        Customer updatedCustomer = this.customerService.update(c, id);
        if (updatedCustomer != null) return ResponseEntity.ok(updatedCustomer);
        return ResponseEntity.notFound().build();
    }
}

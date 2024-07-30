package com.JERZ.GroceryGurus.service;

import org.springframework.stereotype.Service;

import com.JERZ.GroceryGurus.entity.Customer;
import com.JERZ.GroceryGurus.repository.CustomerRepository;

import java.util.Optional;
import java.util.List;
@Service

public class CustomerService {
    
    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    public Customer findById(Integer id) {
        Optional<Customer> optCustomer = customerRepository.findById(id);
        return optCustomer.orElse(null);
    }

    public void create(Customer c) {
        this.customerRepository.save(c);
    }

    public Customer update(Customer c, Integer id) {
        Optional<Customer> optCustomer = this.customerRepository.findById(id);
        if (!optCustomer.isPresent()) return null;
        Customer customer = optCustomer.get();
        if (c.getFirstName() != null) {
            customer.setFirstName(c.getFirstName());
        }
        if (c.getLastName() != null) {
            customer.setLastName(c.getLastName());
        }
        if (c.getEmailAddress() != null) {
            customer.setEmailAddress(c.getEmailAddress());
        }
        if (c.getPassword() != null) {
            customer.setPassword(c.getPassword());
        } 
        if (c.getStreetAddress() != null) {
            customer.setStreetAddress(c.getStreetAddress());
        } 
        if (c.getPhoneNumber() != null) {
            customer.setPhoneNumber(c.getPhoneNumber());
        }
        if (c.getAge() != null) {
            customer.setAge(c.getAge());
        }
        return customerRepository.save(customer);
    }
    public void delete(Integer id) {
        this.customerRepository.deleteById(id);
    }
}

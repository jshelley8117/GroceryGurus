package com.JERZ.GroceryGurus.service;

import com.JERZ.GroceryGurus.repository.CustomerRepository;
import com.JERZ.GroceryGurus.model.Customer;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerService {
    
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }

    public Iterable<Customer> findAllCustomers() { return this.customerRepository.findAll(); }

    public Optional<Customer> findCustomerById(Integer id) { return this.customerRepository.findById(id); }

    public Customer createCustomer(Customer customer) { return this.customerRepository.save(customer); }

    public void deleteCustomer(Integer id) { this.customerRepository.deleteById(id); }

    public Customer updateCustomer(Integer id, Customer c) {
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
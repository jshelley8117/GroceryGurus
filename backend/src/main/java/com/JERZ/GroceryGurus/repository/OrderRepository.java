package com.JERZ.GroceryGurus.repository;
import com.JERZ.GroceryGurus.model.Order;
import org.springframework.data.repository.CrudRepository;
public interface OrderRepository extends CrudRepository<Order, Integer> {
    
}
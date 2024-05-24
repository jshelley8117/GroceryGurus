package com.JERZ.GroceryGurus.service;

import com.JERZ.GroceryGurus.model.Order;
import com.JERZ.GroceryGurus.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) { this.orderRepository = orderRepository; }

    public Iterable<Order> findAllOrders() { return this.orderRepository.findAll(); }

    public Optional<Order> findOrderById(Integer id) { return this.orderRepository.findById(id); }

    public Order createOrder(Order order) { return this.orderRepository.save(order); }
 
    public void deleteOrder(Integer id) { this.orderRepository.deleteById(id); }

    /* 
     * for this endpoint, we should only allow admin users to change an order's date/time and total price.
     * it would not make sense for us to change an order's order_id or customer_id
     */
    public Order updateOrder(Integer id, Order o) { 
        Optional<Order> orderToUpdateOptional = this.orderRepository.findById(id);
        if(!orderToUpdateOptional.isPresent()) return null;
        Order orderToUpdate = orderToUpdateOptional.get();
        orderToUpdate.setOrder_date(o.getOrder_date());
        orderToUpdate.setTotal_price(o.getTotal_price());
        Order updatedOrder = this.orderRepository.save(orderToUpdate);
        return updatedOrder;
    }
}
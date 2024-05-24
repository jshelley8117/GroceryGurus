package com.JERZ.GroceryGurus.controller;

import com.JERZ.GroceryGurus.model.Order;
import com.JERZ.GroceryGurus.service.OrderService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderController {
    
    private final OrderService orderService;
    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @GetMapping("/orders")
    public Iterable<Order> getAllOrders() { return this.orderService.findAllOrders(); }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Integer id) {
        Optional<Order> order = this.orderService.findOrderById(id);
        return (order.isPresent()) ? ResponseEntity.ok(order.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) { return this.orderService.createOrder(order); }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable("id") Integer id) { this.orderService.deleteOrder(id); }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Integer id,
    @RequestBody Order o) {
        Order updatedOrder = this.orderService.updateOrder(id, o);
        return (updatedOrder != null) ? ResponseEntity.ok(updatedOrder) : ResponseEntity.notFound().build();
    }
}
package com.example.productos.controller;

import com.example.productos.model.Order;
import com.example.productos.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getOrders(@RequestParam(required = false) String userEmail) {
        if (userEmail != null) {
            return orderRepository.findByUserEmail(userEmail);
        }
        return orderRepository.findAll();
    }
}
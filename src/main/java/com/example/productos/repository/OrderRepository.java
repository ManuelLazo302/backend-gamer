package com.example.productos.repository;

import com.example.productos.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByDateCreated(LocalDateTime dateCreated);
}
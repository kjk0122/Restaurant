package com.example.kjkindi.repository;

import com.example.kjkindi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order, Long>{
}

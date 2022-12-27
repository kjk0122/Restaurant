package com.example.kjkindi.repository;

import com.example.kjkindi.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long>{
}

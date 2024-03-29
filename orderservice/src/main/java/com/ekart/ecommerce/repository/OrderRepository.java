package com.ekart.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.ecommerce.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
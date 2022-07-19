package com.ekart.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.ecommerce.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
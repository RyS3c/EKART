package com.ekart.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.ecommerce.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public default List<Product> findAllByCategory(String category) {
        return null;
    }

    public default List<Product> findAllByProductName(String name) {
        return null;
    }
}

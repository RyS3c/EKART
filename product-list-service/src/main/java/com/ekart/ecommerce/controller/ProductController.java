package com.ekart.ecommerce.controller;

import com.ekart.ecommerce.entity.Product;
//import com.ekart.ecommerce.http.header.HeaderGenerator;
import com.ekart.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProduct();

        if (!products.isEmpty()) {
            return new ResponseEntity<>(
                    products,
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<List<Product>>(
                HttpStatus.NOT_FOUND
        );
    }


    @GetMapping(value = "/products", params = "category")
    public ResponseEntity<List<Product>> getAllProductByCategory(@RequestParam("category") String category) {
        List<Product> products = productService.getAllProductByCategory(category);
        if (!products.isEmpty()) {
            return new ResponseEntity<List<Product>>(
                    products,
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<List<Product>>(
                HttpStatus.NOT_FOUND
        );
    }


    @GetMapping(value = "/products/{id}")
    public ResponseEntity<List<Product>> getAllProductByName(@RequestParam("id") Long id) {
        List<Product> products = productService.getAllProductsByName(String.valueOf(id));

        if (!products.isEmpty()) {
            return new ResponseEntity<List<Product>>(
                    products,
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<List<Product>>(
                HttpStatus.NOT_FOUND
        );
    }

    @GetMapping(value = "/products", params = "name")
    public ResponseEntity<List<Product>> getAllProductsByName(@RequestParam("name") String name) {
        List<Product> products = productService.getAllProductsByName(name);
        if (!products.isEmpty()) {
            return new ResponseEntity<List<Product>>(
                    products,
                    HttpStatus.OK);
        }
        return new ResponseEntity<List<Product>>(
                HttpStatus.NOT_FOUND
        );
    }
}

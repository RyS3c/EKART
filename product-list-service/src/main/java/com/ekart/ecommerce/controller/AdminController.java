package com.ekart.ecommerce.controller;

import com.ekart.ecommerce.entity.Product;
import com.ekart.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;



    @PostMapping(value = "/products")
    private ResponseEntity<Product> addProduct(@RequestBody Product product, HttpServletRequest request){
        if (product != null){
            try{
                productService.addProduct(product);
                return new ResponseEntity<Product>(
                        product,
                        HttpStatus.CREATED
                        );

            } catch (Exception e) {
                e.printStackTrace();
                return  new ResponseEntity<Product>(
                        HttpStatus.INTERNAL_SERVER_ERROR
                );
            }
        }
        return new ResponseEntity<Product>(
                HttpStatus.BAD_REQUEST
        );
    }

    @DeleteMapping(value = "/products/{id}")
    private ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        Optional<Product> product = productService.getProductById(id);
        if(product != null) {
            try {
                productService.deleteProduct(id);
                return new ResponseEntity<Void>(
                        HttpStatus.OK);
            }catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Void>(
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Void>( HttpStatus.NOT_FOUND);
    }
}

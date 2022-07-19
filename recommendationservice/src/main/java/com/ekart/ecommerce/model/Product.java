package com.ekart.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "products")
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "product_name")
    private String productName;

    @OneToMany (mappedBy = "product")
    @JsonIgnore
    private List<Recom> recomendations;

    public Product() {

    }

    public Product(String productName, List<Recom> recomendations) {
        this.productName = productName;
        this.recomendations = recomendations;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Recom> getRecomendations() {
        return recomendations;
    }

    public void setRecomendations(List<Recom> recomendations) {
        this.recomendations = recomendations;
    }
}
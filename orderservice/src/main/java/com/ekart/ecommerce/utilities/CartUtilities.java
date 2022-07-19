package com.ekart.ecommerce.utilities;

import java.math.BigDecimal;

import com.ekart.ecommerce.entity.Product;

public class CartUtilities {

    public static BigDecimal getSubTotalForItem(Product product, int quantity){
        return (product.getPrice()).multiply(BigDecimal.valueOf(quantity));
    }
}
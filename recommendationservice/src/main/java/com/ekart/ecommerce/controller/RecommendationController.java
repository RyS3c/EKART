package com.ekart.ecommerce.controller;

import com.ekart.ecommerce.feignclient.ProductClient;
import com.ekart.ecommerce.feignclient.UserClient;
import com.ekart.ecommerce.model.Product;
import com.ekart.ecommerce.model.Recom;
import com.ekart.ecommerce.model.User;
import com.ekart.ecommerce.service.RecommendationService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@NoArgsConstructor
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private UserClient userClient;


    @GetMapping(value = "/recommendations")
    private ResponseEntity<List<Recom>> getAllRating(@RequestParam("name") String productName){
        List<Recom> recommendations = recommendationService.getAllRecommendationByProductName(productName);
        if(!recommendations.isEmpty()) {
            return new ResponseEntity<List<Recom>>(
                    recommendations,
                    HttpStatus.OK);
        }
        return new ResponseEntity<List<Recom>>(
                HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/{userId}/recommendations/{productId}")
    private ResponseEntity<Recom> saveRecommendations(
            @PathVariable ("userId") Long userId,
            @PathVariable ("productId") Long productId,
            @RequestParam ("rating") int rating,
            HttpServletRequest request){

        Product product = productClient.getProductById(productId);
        User user = userClient.getUserById(userId);

        if(product != null && user != null) {
            try {
                Recom recommendation = new Recom();
                recommendation.setProduct(product);
                recommendation.setUser(user);
                recommendation.setRating(rating);
                recommendationService.saveRecommendation(recommendation);
                return new ResponseEntity<Recom>(
                        recommendation,
                        HttpStatus.CREATED);
            }catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Recom>(
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Recom>(
                HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/recommendations/{id}")
    private ResponseEntity<Void> deleteRecommendations(@PathVariable("id") Long id){
        Optional<Recom> recommendation = recommendationService.getRecommendationById(id);
        if(recommendation != null) {
            try {
                recommendationService.deleteRecommendation(id);
                return new ResponseEntity<Void>(
                        HttpStatus.OK);
            }catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Void>(
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Void>(
                HttpStatus.NOT_FOUND);
    }
}
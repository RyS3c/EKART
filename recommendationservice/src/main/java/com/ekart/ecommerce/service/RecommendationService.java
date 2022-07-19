package com.ekart.ecommerce.service;

import com.ekart.ecommerce.model.Recom;

import java.util.List;
import java.util.Optional;

public interface RecommendationService {
    Optional<Recom> getRecommendationById(Long recommendationId);
    Recom saveRecommendation(Recom recom);
    List<Recom> getAllRecommendationByProductName(String productName);
    void deleteRecommendation(Long id);
}

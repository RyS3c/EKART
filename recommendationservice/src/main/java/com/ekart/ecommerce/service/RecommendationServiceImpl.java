package com.ekart.ecommerce.service;

import com.ekart.ecommerce.model.Recom;
import com.ekart.ecommerce.repository.RecomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecomRepository recommendationRepository;

    @Override
    public Recom saveRecommendation(Recom recommendation) {
        return recommendationRepository.save(recommendation);
    }

    @Override
    public List<Recom> getAllRecommendationByProductName(String productName) {
        return recommendationRepository.findAllRatingByProductName(productName);
    }

    @Override
    public void deleteRecommendation(Long id) {
        recommendationRepository.deleteById(id);
    }

    @Override
    public Optional<Recom> getRecommendationById(Long recommendationId) {
        return recommendationRepository.findById(recommendationId);
    }
}
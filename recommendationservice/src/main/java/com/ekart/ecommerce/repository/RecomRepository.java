package com.ekart.ecommerce.repository;


import com.ekart.ecommerce.model.Recom;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RecomRepository extends JpaRepository<Recom, Long> {
    @Query("select r FROM Recommendation r WHERE r.product.productName = :productName")
    public List<Recom> findAllRatingByProductName(@Param("productName") String productName);
}

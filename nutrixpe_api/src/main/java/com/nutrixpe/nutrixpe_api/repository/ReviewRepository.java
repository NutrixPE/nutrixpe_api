package com.nutrixpe.nutrixpe_api.repository;

import com.nutrixpe.nutrixpe_api.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByNutritionistId(Long nutritionist);

    List<Review> findByUserId(Long userId);
}

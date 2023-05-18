package com.nutrixpe.nutrixpe_api.service.impl;

import com.nutrixpe.nutrixpe_api.model.Review;
import com.nutrixpe.nutrixpe_api.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long reviewId, Review reviewDetails) {
        Review existingReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        existingReview.setComment(reviewDetails.getComment());
        existingReview.setRating(reviewDetails.getRating());

        return reviewRepository.save(existingReview);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public List<Review> getReviewsByNutritionistId(Long nutritionistId) {
        return reviewRepository.findByNutritionistId(nutritionistId);
    }

    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }
}

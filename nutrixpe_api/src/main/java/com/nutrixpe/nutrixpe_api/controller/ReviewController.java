package com.nutrixpe.nutrixpe_api.controller;

import com.nutrixpe.nutrixpe_api.dto.ReviewDTO;
import com.nutrixpe.nutrixpe_api.model.Review;
import com.nutrixpe.nutrixpe_api.service.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewServiceImpl reviewServiceImpl;

    @Autowired
    public ReviewController(ReviewServiceImpl reviewServiceImpl) {
        this.reviewServiceImpl = reviewServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody ReviewDTO reviewDto) {
        Review createdReview = reviewServiceImpl.createReview(mapReviewDtoToReview(reviewDto));
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(
            @PathVariable("reviewId") Long reviewId,
            @RequestBody ReviewDTO reviewDto
    ) {
        Review updatedReview = reviewServiceImpl.updateReview(reviewId, mapReviewDtoToReview(reviewDto));
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable("reviewId") Long reviewId) {
        reviewServiceImpl.deleteReview(reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/nutritionists/{nutritionistId}")
    public ResponseEntity<List<Review>> getReviewsByNutritionistId(
            @PathVariable("nutritionistId") Long nutritionistId
    ) {
        List<Review> reviews = reviewServiceImpl.getReviewsByNutritionistId(nutritionistId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUserId(
            @PathVariable("userId") Long userId
    ) {
        List<Review> reviews = reviewServiceImpl.getReviewsByUserId(userId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    private Review mapReviewDtoToReview(ReviewDTO reviewDto) {
        return new Review(
                reviewDto.getUserId(),
                reviewDto.getNutritionistId(),
                reviewDto.getComment(),
                reviewDto.getRating()
        );
    }
}

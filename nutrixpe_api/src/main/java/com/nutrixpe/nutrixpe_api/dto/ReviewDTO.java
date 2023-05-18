package com.nutrixpe.nutrixpe_api.dto;

public class ReviewDTO {
    private Long nutritionistId;
    private Long userId;
    private int rating;
    private String comment;

    // Constructor vacío
    public ReviewDTO() {
    }

    // Constructor con todos los campos
    public ReviewDTO(Long nutritionistId, Long userId, int rating, String comment) {
        this.nutritionistId = nutritionistId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters y setters

    public Long getNutritionistId() {
        return nutritionistId;
    }

    public void setNutritionistId(Long nutritionistId) {
        this.nutritionistId = nutritionistId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

package com.demo99.backend.services;

import com.demo99.backend.model.entities.Review;

import java.util.List;

public interface ReviewService {
    Review addReview(Review review);
    List<Review> getReviewsByProvider(Long providerId);
}

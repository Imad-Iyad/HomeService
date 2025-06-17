package com.demo99.backend.services;

import com.demo99.backend.model.dto.ReviewReqDTO;
import com.demo99.backend.model.dto.ReviewResDTO;

import java.util.List;

public interface ReviewService {
    ReviewResDTO addReview(ReviewReqDTO reviewReqDTO);
    List<ReviewResDTO> getReviewsByProvider(Long providerId);
}

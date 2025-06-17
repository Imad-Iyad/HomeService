package com.demo99.backend.services.Implementations;

import com.demo99.backend.exceptions.ResourceNotFoundException;
import com.demo99.backend.model.dto.ReviewReqDTO;
import com.demo99.backend.model.dto.ReviewResDTO;
import com.demo99.backend.model.entities.Review;
import com.demo99.backend.model.entities.User;
import com.demo99.backend.model.mapper.Impl.ReviewMapper;
import com.demo99.backend.repositories.ReviewRepository;
import com.demo99.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserRepository userRepository;

    public ReviewResDTO addReview(ReviewReqDTO reviewReqDTO){
        Review review = this.reviewMapper.toEntity(reviewReqDTO);
        return this.reviewMapper.toDto(this.reviewRepository.save(review));
    }

    public List<ReviewResDTO> getReviewsByProvider(Long providerId){
        Optional<User> potUser = this.userRepository.findById(providerId);
        if (potUser.isPresent()) {
            List<Review> review = reviewRepository.findByProviderId(providerId);
            return this.reviewMapper.toListDto(review);
        }else {
            throw new ResourceNotFoundException("Provider not found");
        }

    }
}

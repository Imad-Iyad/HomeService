package com.demo99.backend.controllers;

import com.demo99.backend.model.dto.ReviewReqDTO;
import com.demo99.backend.model.dto.ReviewResDTO;
import com.demo99.backend.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/Reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ReviewResDTO addReview(@RequestBody ReviewReqDTO reviewReqDTO){
        return this.reviewService.addReview(reviewReqDTO);
    }

    @GetMapping("/{id}")
    public List<ReviewResDTO> getReviewsByProvider(@PathVariable Long id){
        return this.reviewService.getReviewsByProvider(id);
    }

}

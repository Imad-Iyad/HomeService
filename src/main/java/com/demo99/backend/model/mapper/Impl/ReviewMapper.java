package com.demo99.backend.model.mapper.Impl;

import com.demo99.backend.model.dto.ReviewReqDTO;
import com.demo99.backend.model.dto.ReviewResDTO;
import com.demo99.backend.model.entities.Review;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review toEntity(ReviewReqDTO dto);
    ReviewResDTO toDto(Review entity);
    List<ReviewResDTO> toListDto(List<Review> entity);
}

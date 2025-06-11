package com.demo99.backend.model.mapper.Impl;

import com.demo99.backend.model.dto.UserReqDTO;
import com.demo99.backend.model.dto.UserResDTO;
import com.demo99.backend.model.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserReqDTO userReqDTO);

    UserResDTO toDto(User user);
}

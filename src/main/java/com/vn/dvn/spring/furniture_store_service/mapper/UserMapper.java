package com.vn.dvn.spring.furniture_store_service.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserCreationRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserUpdateRequest;
import com.vn.dvn.spring.furniture_store_service.dto.response.UserResponse;
import com.vn.dvn.spring.furniture_store_service.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toUser(UserCreationRequest request);

    void toUpdateUser(@MappingTarget Users user, UserUpdateRequest userUpdateRequest);

    UserResponse toUserResponse(Users user);

    List<UserResponse> toUserResponseList(List<Users> userList);
}

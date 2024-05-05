package com.vn.dvn.spring.furniture_store_service.service.user_service;

import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserCreationRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserUpdateRequest;
import com.vn.dvn.spring.furniture_store_service.dto.response.UserResponse;
import com.vn.dvn.spring.furniture_store_service.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponse createUser(UserCreationRequest request);

    List<UserResponse> findAllUser();

    UserResponse getMyInfo();

    Users findById(String id);

    UserResponse updateUser(String id, UserUpdateRequest request);
}

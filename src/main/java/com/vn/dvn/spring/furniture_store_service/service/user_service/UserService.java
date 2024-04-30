package com.vn.dvn.spring.furniture_store_service.service.user_service;

import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserCreationRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserUpdateRequest;
import com.vn.dvn.spring.furniture_store_service.dto.response.UserResponse;
import com.vn.dvn.spring.furniture_store_service.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public UserResponse createUser(UserCreationRequest request);

    public List<UserResponse> findAllUser();

    public Optional<Users> findByEmail(String email);

    public Users findById(String id);

    public UserResponse updateUser(String id, UserUpdateRequest request);
}

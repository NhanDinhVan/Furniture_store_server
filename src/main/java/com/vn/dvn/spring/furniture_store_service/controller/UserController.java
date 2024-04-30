package com.vn.dvn.spring.furniture_store_service.controller;

import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserCreationRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserUpdateRequest;
import com.vn.dvn.spring.furniture_store_service.dto.response.ApiResponse;
import com.vn.dvn.spring.furniture_store_service.dto.response.UserResponse;
import com.vn.dvn.spring.furniture_store_service.entity.Users;
import com.vn.dvn.spring.furniture_store_service.service.user_service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/v1/users")
public class UserController {
    UserService service;

    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUser()
    {
        ApiResponse api = new ApiResponse();
        api.setResult(service.findAllUser());
        return api;
    }

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request)
    {
        ApiResponse<UserResponse> apiResponse= new ApiResponse<>();

        apiResponse.setResult(service.createUser(request));
        return apiResponse;
    }

    @GetMapping("/email/{email}")
    public Optional<Users> getUserByEmail(@PathVariable String email)
    {
        return service.findByEmail(email);
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable String id)
    {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable  String id, @RequestBody @Valid UserUpdateRequest request)
    {
        ApiResponse<UserResponse> api = new ApiResponse<>();
        api.setResult(service.updateUser(id, request));
        return api;
    }
}

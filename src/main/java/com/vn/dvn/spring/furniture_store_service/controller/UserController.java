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
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/v1/users")
public class UserController {
    UserService service;

    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUser()
    {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("UserName: "+ authentication.getName());
       authentication.getAuthorities().forEach(
               grantedAuthority -> log.info(grantedAuthority.getAuthority())
       );
        log.info("In method get all user");

        return ApiResponse.<List<UserResponse>>builder()
                .result(service.findAllUser())
                .build();
    }

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request)
    {
        ApiResponse<UserResponse> apiResponse= new ApiResponse<>();

        apiResponse.setResult(service.createUser(request));
        return apiResponse;
    }

    @PutMapping("/{id}")
    ApiResponse<UserResponse> updateUser(@PathVariable  String id, @RequestBody @Valid UserUpdateRequest request)
    {
        ApiResponse<UserResponse> api = new ApiResponse<>();
        api.setResult(service.updateUser(id, request));
        return api;
    }

    @GetMapping("/myInfo")
    ApiResponse<UserResponse> getInfo()
    {
        return ApiResponse.<UserResponse>builder()
                .result(service.getMyInfo())
                .code(1000)
                .build();
    }
}

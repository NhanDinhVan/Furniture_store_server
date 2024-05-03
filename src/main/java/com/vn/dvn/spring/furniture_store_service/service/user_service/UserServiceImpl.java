package com.vn.dvn.spring.furniture_store_service.service.user_service;

import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserCreationRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserUpdateRequest;
import com.vn.dvn.spring.furniture_store_service.dto.response.UserResponse;
import com.vn.dvn.spring.furniture_store_service.entity.Users;
import com.vn.dvn.spring.furniture_store_service.enums.Role;
import com.vn.dvn.spring.furniture_store_service.handle_exception.AppException;
import com.vn.dvn.spring.furniture_store_service.handle_exception.ErrorCode;
import com.vn.dvn.spring.furniture_store_service.mapper.UserMapper;
import com.vn.dvn.spring.furniture_store_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository repository;
    UserMapper mapper;

    @Override
    public UserResponse createUser(UserCreationRequest request) {
        if(repository.existsByEmail(request.getEmail()))
            throw new AppException(ErrorCode.USER_EXISTED);

        Users user = mapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        user.setPassword(passwordEncoder.encode(request.getPassword()));


        user.setRole(String.valueOf(Role.USER));
//        HashSet<String> role = new HashSet<>();
//        role.add(Role.USER.name());
//        user.setRole(role);
        return mapper.toUserResponse(repository.save(user));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public List<UserResponse> findAllUser() {
        return mapper.toUserResponseList(repository.findAll());
    }


    @Override
    @PostAuthorize("returnObject.email==authentication.name")
    public Users findById(String id)
    {
        return repository.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.USER_NOTFOUND));
    }

    @Override
    public UserResponse updateUser(String id, UserUpdateRequest request) {
        Users user = findById(id);

        return mapper.toUserResponse(repository.save(user));
    }

    @Override
    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        Users user = repository.findByEmail(name)
                .orElseThrow(()-> new AppException(ErrorCode.USER_NOTFOUND));
        return mapper.toUserResponse(user);
    }

}

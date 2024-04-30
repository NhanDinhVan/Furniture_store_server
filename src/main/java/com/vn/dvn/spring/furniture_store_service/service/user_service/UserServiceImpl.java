package com.vn.dvn.spring.furniture_store_service.service.user_service;

import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserCreationRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserUpdateRequest;
import com.vn.dvn.spring.furniture_store_service.dto.response.UserResponse;
import com.vn.dvn.spring.furniture_store_service.entity.Users;
import com.vn.dvn.spring.furniture_store_service.handle_exception.AppException;
import com.vn.dvn.spring.furniture_store_service.handle_exception.ErrorCode;
import com.vn.dvn.spring.furniture_store_service.mapper.UserMapper;
import com.vn.dvn.spring.furniture_store_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        return mapper.toUserResponse(repository.save(user));
    }

    @Override
    public List<UserResponse> findAllUser() {
        return mapper.toUserResponseList(repository.findAll());
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return repository.findByEmail(email);
    }
    @Override
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


}

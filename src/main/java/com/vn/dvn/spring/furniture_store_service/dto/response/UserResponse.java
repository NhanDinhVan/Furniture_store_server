package com.vn.dvn.spring.furniture_store_service.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserResponse {
    String id;
    String name;
    String address;
    String gender;
    int purchased;
    String email;
    String phoneNumber;
    String role;
    String state;
}

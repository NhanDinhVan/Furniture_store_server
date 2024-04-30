package com.vn.dvn.spring.furniture_store_service.dto.request.user_request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateRequest {
     String name;
     String address;
     String gender;
     int purchased;
     String phoneNumber;
     @Size(min = 8, message = "INVALID_PASSWORD")
     String password;
     String state;
}

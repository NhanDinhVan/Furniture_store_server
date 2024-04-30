package com.vn.dvn.spring.furniture_store_service.dto.request.user_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
     String name;
     String address;
     String gender;
     int purchased;
     @Email(message = "INVALID_EMAIL")
     String email;
     String phoneNumber;
     @Size(min = 8, message = "INVALID_PASSWORD")
     String password;
     String role;
     String state;
}

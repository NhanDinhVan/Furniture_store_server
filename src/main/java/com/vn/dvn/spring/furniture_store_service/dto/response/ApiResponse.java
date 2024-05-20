package com.vn.dvn.spring.furniture_store_service.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    int code = 1000;
    String message= "Success";
    T result;
}

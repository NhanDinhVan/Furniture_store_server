package com.vn.dvn.spring.furniture_store_service.dto.request.brand_request;

import lombok.*;
import lombok.experimental.FieldDefaults;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OtherBrandRequest {
        String brandId;
        String name;
}

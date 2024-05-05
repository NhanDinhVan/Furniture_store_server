package com.vn.dvn.spring.furniture_store_service.dto.request.product_request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdationRequest {
    String name;

    String description;

    Float price;

    int quantity;

    String imagePath;

    String brand;

    Float discount;

}

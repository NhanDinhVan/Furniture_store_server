package com.vn.dvn.spring.furniture_store_service.dto.request.product_request;

import com.vn.dvn.spring.furniture_store_service.entity.Brands;
import com.vn.dvn.spring.furniture_store_service.entity.Category;
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

    Category category;

    Brands brand;

    Float discount;

}

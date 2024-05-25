package com.vn.dvn.spring.furniture_store_service.dto.request.category_request;

import lombok.*;
import lombok.experimental.FieldDefaults;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OtherCategoryRequest {
        String categoryId;
        String name;
}

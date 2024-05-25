package com.vn.dvn.spring.furniture_store_service.service.product_service;

import com.vn.dvn.spring.furniture_store_service.dto.request.product_request.ProductCreationRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.product_request.ProductUpdationRequest;
import com.vn.dvn.spring.furniture_store_service.entity.Products;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

public interface ProductService {
        Products create(ProductCreationRequest request);

        Products update(String id, ProductUpdationRequest request);

        List<Products> findAll();

        Products findById(String id);
        List<Products> findBySales(int top);

        Products delete(String id);


}

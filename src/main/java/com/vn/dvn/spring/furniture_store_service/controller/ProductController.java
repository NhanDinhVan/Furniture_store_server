package com.vn.dvn.spring.furniture_store_service.controller;

import com.vn.dvn.spring.furniture_store_service.dto.request.product_request.ProductCreationRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.product_request.ProductUpdationRequest;
import com.vn.dvn.spring.furniture_store_service.dto.response.ApiResponse;
import com.vn.dvn.spring.furniture_store_service.entity.Products;
import com.vn.dvn.spring.furniture_store_service.service.product_service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping
    public ApiResponse<List<Products>> getAll()
    {
        return ApiResponse.<List<Products>>builder()
                .result(service.findAll())
                .code(1000)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<Products> getById(@PathVariable String id)
    {
        return ApiResponse.<Products>builder()
                .result(service.findById(id))
                .code(1000)
                .build();
    }

    @PostMapping
    public ApiResponse<Products> addProduct(@RequestBody ProductCreationRequest request)
    {
        return ApiResponse.<Products>builder()
                .code(1000)
                .result(service.create(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<Products> updateProduct(@PathVariable String id, @RequestBody ProductUpdationRequest request)
    {
        return ApiResponse.<Products>builder()
                .result(service.update(id, request))
                .code(1000)
                .build();
    }

}

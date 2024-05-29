package com.vn.dvn.spring.furniture_store_service.controller;

import com.vn.dvn.spring.furniture_store_service.dto.request.brand_request.AddBrandRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.brand_request.OtherBrandRequest;
import com.vn.dvn.spring.furniture_store_service.dto.response.ApiResponse;
import com.vn.dvn.spring.furniture_store_service.entity.Brands;
import com.vn.dvn.spring.furniture_store_service.service.brands_service.BrandsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/brands")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BrandController {
    final BrandsService brandService;

    @GetMapping
    public ApiResponse<List<Brands>> getAll()
    {
        return ApiResponse.<List<Brands>>builder()
                .code(1000)
                .message("success")
                .result(brandService.findAll())
                .build();
    }

    @PostMapping
    public ApiResponse<Brands> addBrand(@RequestBody AddBrandRequest request)
    {
        return ApiResponse.<Brands>builder()
                .result(brandService.create(request))
                .message("success")
                .code(1000)
                .build();
    }
    @DeleteMapping
    public ApiResponse<Void> deleteBrand(@RequestBody OtherBrandRequest request)
    {
        brandService.dalete(request);
        return ApiResponse.<Void>builder()
                .message("success")
                .code(1000)
                .build();
    }
}

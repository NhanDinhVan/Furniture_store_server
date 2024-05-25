package com.vn.dvn.spring.furniture_store_service.controller;

import com.vn.dvn.spring.furniture_store_service.dto.request.category_request.AddCategoryRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.category_request.OtherCategoryRequest;
import com.vn.dvn.spring.furniture_store_service.dto.response.ApiResponse;
import com.vn.dvn.spring.furniture_store_service.entity.Category;
import com.vn.dvn.spring.furniture_store_service.service.category_service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/category")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryController {
    final CategoryService categoryService;

    @GetMapping
    public ApiResponse<List<Category>> getAll()
    {
        return ApiResponse.<List<Category>>builder()
                .code(1000)
                .message("success")
                .result(categoryService.findAll())
                .build();
    }

    @PostMapping
    public ApiResponse<Category> addCategory(@RequestBody AddCategoryRequest request)
    {
        return ApiResponse.<Category>builder()
                .result(categoryService.create(request))
                .message("success")
                .code(1000)
                .build();
    }
    @DeleteMapping
    public ApiResponse<Void> deleteCategory(@RequestBody OtherCategoryRequest request)
    {
        categoryService.dalete(request);
        return ApiResponse.<Void>builder()
                .message("success")
                .code(1000)
                .build();
    }
}

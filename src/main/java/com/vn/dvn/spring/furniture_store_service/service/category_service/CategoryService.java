package com.vn.dvn.spring.furniture_store_service.service.category_service;

import com.vn.dvn.spring.furniture_store_service.dto.request.category_request.AddCategoryRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.category_request.OtherCategoryRequest;
import com.vn.dvn.spring.furniture_store_service.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();
    public Category create(AddCategoryRequest request);
    public void dalete(OtherCategoryRequest request);
    public Category update(OtherCategoryRequest request);

}

package com.vn.dvn.spring.furniture_store_service.service.brands_service;

import com.vn.dvn.spring.furniture_store_service.dto.request.brand_request.AddBrandRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.brand_request.OtherBrandRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.category_request.AddCategoryRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.category_request.OtherCategoryRequest;
import com.vn.dvn.spring.furniture_store_service.entity.Brands;
import com.vn.dvn.spring.furniture_store_service.entity.Category;

import java.util.List;

public interface BrandsService {
    public List<Brands> findAll();
    public Brands create(AddBrandRequest request);
    public void dalete(OtherBrandRequest request);
    public Brands update(OtherBrandRequest request);

}

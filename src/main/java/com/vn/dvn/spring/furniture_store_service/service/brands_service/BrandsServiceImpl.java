package com.vn.dvn.spring.furniture_store_service.service.brands_service;

import com.vn.dvn.spring.furniture_store_service.dto.request.brand_request.AddBrandRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.brand_request.OtherBrandRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.category_request.AddCategoryRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.category_request.OtherCategoryRequest;
import com.vn.dvn.spring.furniture_store_service.entity.Brands;
import com.vn.dvn.spring.furniture_store_service.entity.Category;
import com.vn.dvn.spring.furniture_store_service.handle_exception.AppException;
import com.vn.dvn.spring.furniture_store_service.handle_exception.ErrorCode;
import com.vn.dvn.spring.furniture_store_service.repository.BrandRepository;
import com.vn.dvn.spring.furniture_store_service.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BrandsServiceImpl implements BrandsService {
    final BrandRepository brandRepository;
    @Override
    public List<Brands> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brands create(AddBrandRequest request) {
        String name = request.getName().trim().substring(0,1).toUpperCase() + request.getName().trim().substring(1).toLowerCase();
        if(brandRepository.existsByName(name))
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        return brandRepository.save(Brands.builder()
                                                .name(name)
                                                .build());
    }

    @Override
    public void dalete(OtherBrandRequest request) {
        if(brandRepository.existsByBrandId(request.getBrandId()))
        {
            brandRepository.delete(brandRepository.findByBrandId(request.getBrandId()));
        }else{
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        }

    }

    @Override
    public Brands update(OtherBrandRequest request) {
        return null;
    }
}

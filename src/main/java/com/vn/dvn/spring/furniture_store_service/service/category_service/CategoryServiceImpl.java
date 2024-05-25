package com.vn.dvn.spring.furniture_store_service.service.category_service;

import com.vn.dvn.spring.furniture_store_service.dto.request.category_request.AddCategoryRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.category_request.OtherCategoryRequest;
import com.vn.dvn.spring.furniture_store_service.entity.Category;
import com.vn.dvn.spring.furniture_store_service.handle_exception.AppException;
import com.vn.dvn.spring.furniture_store_service.handle_exception.ErrorCode;
import com.vn.dvn.spring.furniture_store_service.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryServiceImpl implements CategoryService{
    final CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category create(AddCategoryRequest request) {
        String name = request.getName().trim().substring(0,1).toUpperCase() + request.getName().trim().substring(1).toLowerCase();
        if(categoryRepository.existsByName(name))
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        return categoryRepository.save(Category.builder()
                                                .name(name)
                                                .build());
    }

    @Override
    public void dalete(OtherCategoryRequest request) {
        if(categoryRepository.existsByCategoryId(request.getCategoryId()))
        {
            categoryRepository.delete(categoryRepository.findByCategoryId(request.getCategoryId()));
        }else{
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        }

    }

    @Override
    public Category update(OtherCategoryRequest request) {
        return null;
    }
}

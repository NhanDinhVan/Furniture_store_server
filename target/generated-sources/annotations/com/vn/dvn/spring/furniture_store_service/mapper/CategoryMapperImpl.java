package com.vn.dvn.spring.furniture_store_service.mapper;

import com.vn.dvn.spring.furniture_store_service.dto.request.category_request.OtherCategoryRequest;
import com.vn.dvn.spring.furniture_store_service.entity.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-25T13:30:34+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public void toUpdateCategory(Category category, OtherCategoryRequest request) {
        if ( request == null ) {
            return;
        }

        category.setCategoryId( request.getCategoryId() );
        category.setName( request.getName() );
    }
}

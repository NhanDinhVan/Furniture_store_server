package com.vn.dvn.spring.furniture_store_service.mapper;

import com.vn.dvn.spring.furniture_store_service.dto.request.brand_request.OtherBrandRequest;
import com.vn.dvn.spring.furniture_store_service.entity.Brands;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T14:59:04+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class BrandMapperImpl implements BrandMapper {

    @Override
    public void toUpdateBrand(Brands brand, OtherBrandRequest request) {
        if ( request == null ) {
            return;
        }

        brand.setName( request.getName() );
    }
}

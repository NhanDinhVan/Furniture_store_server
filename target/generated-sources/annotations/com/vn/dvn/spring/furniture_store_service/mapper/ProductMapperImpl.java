package com.vn.dvn.spring.furniture_store_service.mapper;

import com.vn.dvn.spring.furniture_store_service.dto.request.product_request.ProductCreationRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.product_request.ProductUpdationRequest;
import com.vn.dvn.spring.furniture_store_service.entity.Products;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-05T13:55:07+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Products toProduct(ProductCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        Products.ProductsBuilder products = Products.builder();

        products.name( request.getName() );
        products.description( request.getDescription() );
        products.price( request.getPrice() );
        products.quantity( request.getQuantity() );
        products.imagePath( request.getImagePath() );
        products.brand( request.getBrand() );
        products.discount( request.getDiscount() );

        return products.build();
    }

    @Override
    public void toUpdateProduct(Products product, ProductUpdationRequest request) {
        if ( request == null ) {
            return;
        }

        product.setName( request.getName() );
        product.setDescription( request.getDescription() );
        product.setPrice( request.getPrice() );
        product.setQuantity( request.getQuantity() );
        product.setImagePath( request.getImagePath() );
        product.setBrand( request.getBrand() );
        product.setDiscount( request.getDiscount() );
    }
}

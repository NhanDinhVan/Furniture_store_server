package com.vn.dvn.spring.furniture_store_service.mapper;

import com.vn.dvn.spring.furniture_store_service.dto.request.cart_request.CartRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.product_request.ProductUpdationRequest;
import com.vn.dvn.spring.furniture_store_service.entity.Carts;
import com.vn.dvn.spring.furniture_store_service.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CartMapper {

    void toUpdateCart(@MappingTarget Carts cart, CartRequest request);

}

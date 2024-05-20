package com.vn.dvn.spring.furniture_store_service.mapper;

import com.vn.dvn.spring.furniture_store_service.dto.request.cart_request.CartRequest;
import com.vn.dvn.spring.furniture_store_service.entity.Carts;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-20T10:15:43+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public void toUpdateCart(Carts cart, CartRequest request) {
        if ( request == null ) {
            return;
        }

        cart.setQuantity( request.getQuantity() );
    }
}

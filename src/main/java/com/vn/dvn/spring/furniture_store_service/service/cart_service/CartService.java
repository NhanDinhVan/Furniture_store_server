package com.vn.dvn.spring.furniture_store_service.service.cart_service;

import com.vn.dvn.spring.furniture_store_service.dto.request.cart_request.CartRequest;
import com.vn.dvn.spring.furniture_store_service.entity.Carts;

import java.util.List;

public interface CartService {
    Carts addToCart(CartRequest request);

    void removeFromCart(CartRequest request);

    Carts updateCart(CartRequest request);

    List<Carts> findByUserId();


}

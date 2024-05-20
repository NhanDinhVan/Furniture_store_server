package com.vn.dvn.spring.furniture_store_service.service.cart_service;

import com.vn.dvn.spring.furniture_store_service.dto.request.cart_request.CartRequest;
import com.vn.dvn.spring.furniture_store_service.entity.Carts;
import com.vn.dvn.spring.furniture_store_service.entity.Products;
import com.vn.dvn.spring.furniture_store_service.entity.Users;
import com.vn.dvn.spring.furniture_store_service.handle_exception.AppException;
import com.vn.dvn.spring.furniture_store_service.handle_exception.ErrorCode;
import com.vn.dvn.spring.furniture_store_service.mapper.CartMapper;
import com.vn.dvn.spring.furniture_store_service.repository.CartRepository;
import com.vn.dvn.spring.furniture_store_service.repository.ProductRepository;
import com.vn.dvn.spring.furniture_store_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartServiceImpl implements CartService {
    final UserRepository userRepository;
    final CartRepository cartRepository;
    final ProductRepository productRepository;
    final CartMapper cartMapper;

    @Override
    public Carts addToCart( CartRequest request) {
        var context = SecurityContextHolder.getContext();
        String userName = context.getAuthentication().getName()
                .describeConstable().orElseThrow(()-> new AppException(ErrorCode.UNAUTHENTICATED));
        Users user = userRepository.findByEmail(userName)
                .orElseThrow(()-> new AppException(ErrorCode.USER_NOTFOUND));

        Products product = productRepository.findById(request.getProductId())
                .orElseThrow(()->new AppException(ErrorCode.PRODUCT_NOTEXIST));
        Carts cart = cartRepository.findByProductAndUserId(product,user.getId());
        if(cart==null)
        {
            if(productRepository.existsById(request.getProductId()))
            {
                return  cartRepository.save(
                        Carts.builder()
                                .product(productRepository.findById(request.getProductId())
                                        .orElseThrow(()-> new AppException(ErrorCode.PRODUCT_NOTEXIST)))
                                .userId(user.getId())
                                .quantity(request.getQuantity())
                                .build());
            }
        }
        cart.setQuantity(cart.getQuantity()+ request.getQuantity());
        return cartRepository.save(cart);
    }

    @Override
    public void removeFromCart(CartRequest request) {
        var context = SecurityContextHolder.getContext();
        String userName = context.getAuthentication().getName()
                .describeConstable().orElseThrow(()-> new AppException(ErrorCode.UNAUTHENTICATED));
        Users user = userRepository.findByEmail(userName)
                .orElseThrow(()-> new AppException(ErrorCode.USER_NOTFOUND));
        Products product = productRepository.findById(request.getProductId())
                .orElseThrow(()->new AppException(ErrorCode.PRODUCT_NOTEXIST));
        Carts cart = cartRepository.findByProductAndUserId(product,user.getId());
        cartRepository.delete(cart);
    }

    @Override
    public Carts updateCart(CartRequest request) {
        var context = SecurityContextHolder.getContext();
        String userName = context.getAuthentication().getName()
                .describeConstable().orElseThrow(()-> new AppException(ErrorCode.UNAUTHENTICATED));
        Users user = userRepository.findByEmail(userName)
                .orElseThrow(()-> new AppException(ErrorCode.USER_NOTFOUND));

        Products product = productRepository.findById(request.getProductId())
                .orElseThrow(()->new AppException(ErrorCode.PRODUCT_NOTEXIST));

        Carts cart = cartRepository.findByProductAndUserId(product,user.getId());
        if(cart==null)
            return  cartRepository.save(
                        Carts.builder()
                                .product(productRepository.findById(request.getProductId())
                                        .orElseThrow(()-> new AppException(ErrorCode.PRODUCT_NOTEXIST)))
                            .userId(user.getId())
                            .quantity(request.getQuantity())
                            .build());

        if(request.getQuantity()<=0) {
            cartRepository.delete(cart);
            cartMapper.toUpdateCart(cart, request);
            return cart;
        }
        cartMapper.toUpdateCart(cart, request);
        return cartRepository.save(cart);
    }

    @Override
    public List<Carts> findByUserId() {
        var context = SecurityContextHolder.getContext();
        String userName = context.getAuthentication().getName()
                .describeConstable().orElseThrow(()-> new AppException(ErrorCode.UNAUTHENTICATED));
        Users user = userRepository.findByEmail(userName)
                .orElseThrow(()-> new AppException(ErrorCode.USER_NOTFOUND));

        return cartRepository.findByUserId(user.getId());
    }


}

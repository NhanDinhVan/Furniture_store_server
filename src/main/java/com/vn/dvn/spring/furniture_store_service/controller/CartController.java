package com.vn.dvn.spring.furniture_store_service.controller;

import com.vn.dvn.spring.furniture_store_service.dto.request.cart_request.CartRequest;
import com.vn.dvn.spring.furniture_store_service.dto.response.ApiResponse;
import com.vn.dvn.spring.furniture_store_service.entity.Carts;
import com.vn.dvn.spring.furniture_store_service.handle_exception.AppException;
import com.vn.dvn.spring.furniture_store_service.handle_exception.ErrorCode;
import com.vn.dvn.spring.furniture_store_service.service.cart_service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public ApiResponse<List<Carts>> getAllByUserId()
    {
        return ApiResponse.<List<Carts>>builder()
                .code(1000)
                .message("success")
                .result(cartService.findByUserId())
                .build();
    }
    @PostMapping
    public ApiResponse<Carts> addToCart(@RequestBody CartRequest cartRequest)
    {
        return ApiResponse.<Carts>builder()
                .code(1000)
                .message("success")
                .result(cartService.addToCart(cartRequest))
                .build();
    }

    @PutMapping
    public ApiResponse<Carts> updateCart(@RequestBody CartRequest cartRequest)
    {
        return ApiResponse.<Carts>builder()
                .code(1000)
                .message("success")
                .result(cartService.updateCart(cartRequest))
                .build();
    }

    @DeleteMapping
    public ApiResponse<Void> deleteCartItem(@RequestBody CartRequest cartRequest)
    {
        cartService.removeFromCart(cartRequest);
        return ApiResponse.<Void>builder()
                .code(1000)
                .message("success")
                .result(null)
                .build();
    }

    @DeleteMapping("/list")
    public ApiResponse<Void> deleteCartItemList(@RequestBody List<CartRequest> cartRequest)
    {
        boolean checkDuplicates = hasDuplicates(cartRequest);
        if(checkDuplicates) throw new AppException(ErrorCode.DUPLICATESD_VALUES);

        cartRequest.forEach(cartService::removeFromCart);
        return ApiResponse.<Void>builder()
                .code(1000)
                .message("success")
                .result(null)
                .build();
    }

    public static <T> boolean hasDuplicates(List<T> list) {
        Set<T> set = new HashSet<>();
        for (T item : list) {
            if (!set.add(item)) {
                return true; // Nếu không thể thêm phần tử vào set, nghĩa là phần tử đã tồn tại
            }
        }
        return false; // Không có phần tử nào trùng lặp
    }
}

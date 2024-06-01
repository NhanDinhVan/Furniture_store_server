package com.vn.dvn.spring.furniture_store_service.controller;

import com.vn.dvn.spring.furniture_store_service.dto.response.ApiResponse;
import com.vn.dvn.spring.furniture_store_service.entity.Banners;
import com.vn.dvn.spring.furniture_store_service.service.banner_service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/banner")
public class BannerController {
    private final BannerService bannerService;
    @GetMapping
    public ApiResponse<List<Banners>> getAll(){
        return ApiResponse.<List<Banners>>builder()
                .message("success")
                .code(1000)
                .result(bannerService.getAll())
                .build();
    }

    @PostMapping
    public ApiResponse<Banners> addBanner(@RequestBody Banners banner)
    {
        return ApiResponse.<Banners>builder()
                .code(1000)
                .message("success")
                .result(bannerService.addBanner(banner))
                .build();
    }

    @DeleteMapping
    public ApiResponse<Void> deleteBanner(@RequestBody Banners banner)
    {
        return ApiResponse.<Void>builder()
                .code(1000)
                .message("success")
                .build();
    }
}

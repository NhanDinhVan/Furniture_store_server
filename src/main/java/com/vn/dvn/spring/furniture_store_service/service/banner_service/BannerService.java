package com.vn.dvn.spring.furniture_store_service.service.banner_service;

import com.vn.dvn.spring.furniture_store_service.entity.Banners;
import org.springframework.boot.Banner;

import java.util.List;

public interface BannerService {
        public List<Banners> getAll();

        public Banners addBanner(Banners banner);

        public void deleteBanner(Banners banner);
}

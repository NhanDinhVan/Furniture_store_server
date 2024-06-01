package com.vn.dvn.spring.furniture_store_service.service.banner_service;

import com.vn.dvn.spring.furniture_store_service.entity.Banners;
import com.vn.dvn.spring.furniture_store_service.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;
    @Override
    public List<Banners> getAll() {
        return bannerRepository.findAll();
    }

    @Override
    public Banners addBanner(Banners banner) {
        return bannerRepository.save(banner);
    }

    @Override
    public void deleteBanner(Banners banner) {
        bannerRepository.delete(banner);
    }

}

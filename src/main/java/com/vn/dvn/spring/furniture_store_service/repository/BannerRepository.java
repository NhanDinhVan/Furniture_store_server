package com.vn.dvn.spring.furniture_store_service.repository;

import com.vn.dvn.spring.furniture_store_service.entity.Banners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banners, String> {

}

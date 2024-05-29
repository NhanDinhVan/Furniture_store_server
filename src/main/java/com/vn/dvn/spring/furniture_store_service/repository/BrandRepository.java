package com.vn.dvn.spring.furniture_store_service.repository;

import com.vn.dvn.spring.furniture_store_service.entity.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brands, String> {
    public Boolean existsByName(String name);

    public Boolean existsByBrandId(String id);
    public Brands findByBrandId(String id);
}

package com.vn.dvn.spring.furniture_store_service.repository;

import com.vn.dvn.spring.furniture_store_service.entity.Carts;
import com.vn.dvn.spring.furniture_store_service.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Carts, String> {

    Boolean existsByProductIdAndUserId(String productId, String userId);

    Boolean existsByUserId(String userId);

    Carts findByProductAndUserId(Products product, String userId);

    List<Carts> findByUserId(String userId);

}

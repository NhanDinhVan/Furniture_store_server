package com.vn.dvn.spring.furniture_store_service.repository;

import com.vn.dvn.spring.furniture_store_service.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, String> {
        boolean existsById(String id);
}

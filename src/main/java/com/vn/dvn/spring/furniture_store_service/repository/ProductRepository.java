package com.vn.dvn.spring.furniture_store_service.repository;

import com.vn.dvn.spring.furniture_store_service.entity.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, String> {
        boolean existsById(String id);
        @Query("SELECT p FROM Products p ORDER BY p.sold DESC")
        List<Products> findByTopSales(Pageable pageable);
}

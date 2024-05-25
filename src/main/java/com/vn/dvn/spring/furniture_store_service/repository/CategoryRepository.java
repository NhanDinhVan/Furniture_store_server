package com.vn.dvn.spring.furniture_store_service.repository;

import com.vn.dvn.spring.furniture_store_service.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    public Boolean existsByName(String name);

    public Boolean existsByCategoryId(String id);
    public Category findByCategoryId(String id);
}

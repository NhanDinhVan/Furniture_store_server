package com.vn.dvn.spring.furniture_store_service.service.product_service;

import com.vn.dvn.spring.furniture_store_service.dto.request.product_request.ProductCreationRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.product_request.ProductUpdationRequest;
import com.vn.dvn.spring.furniture_store_service.entity.Products;
import com.vn.dvn.spring.furniture_store_service.enums.State;
import com.vn.dvn.spring.furniture_store_service.handle_exception.AppException;
import com.vn.dvn.spring.furniture_store_service.handle_exception.ErrorCode;
import com.vn.dvn.spring.furniture_store_service.mapper.ProductMapper;
import com.vn.dvn.spring.furniture_store_service.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;
    private final ProductMapper mapper;

    private String image_path = "http://localhost/Furniture_store_service/src/main/java/com/vn/dvn/spring/furniture_store_service/image/";
    @Override
    public Products create(ProductCreationRequest request) {
        Products product = mapper.toProduct(request);
        product.setView(0);
        product.setSold(0);
        product.setImagePath(image_path+mapper.toProduct(request).getImagePath());
        product.setState(State.ENABLE.toString());
        return repository.save(product);
    }

    @Override
    public Products update(String id, ProductUpdationRequest request) {
        Products product = repository.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.PRODUCT_NOTEXIST));
        mapper.toUpdateProduct(product, request);

        return repository.save(product);
    }

    @Override
    public List<Products> findAll() {
        return repository.findAll();
    }

    @Override
    public Products findById(String id) {
        Products product = repository.findById(id).orElseThrow(()-> new AppException(ErrorCode.PRODUCT_NOTEXIST));
        product.setView(product.getView()+1);
        repository.save(product);
        return product;
    }

    @Override
    public Products delete(String id) {
        findById(id);
        return repository.getById(id);
    }
}

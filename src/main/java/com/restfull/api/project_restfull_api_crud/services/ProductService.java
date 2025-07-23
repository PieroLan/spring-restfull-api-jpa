package com.restfull.api.project_restfull_api_crud.services;

import java.util.List;
import java.util.Optional;

import com.restfull.api.project_restfull_api_crud.entities.Product;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}

package com.restfull.api.project_restfull_api_crud.services;

import java.util.List;
import java.util.Optional;

import com.restfull.api.project_restfull_api_crud.entities.Product;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    Optional<Product> update(Long id, Product product);

    Optional<Product> deleteProduct(Long id);
}

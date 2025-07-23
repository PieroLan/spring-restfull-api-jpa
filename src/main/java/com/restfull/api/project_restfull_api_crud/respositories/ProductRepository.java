package com.restfull.api.project_restfull_api_crud.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restfull.api.project_restfull_api_crud.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

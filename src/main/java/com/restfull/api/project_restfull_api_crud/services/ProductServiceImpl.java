package com.restfull.api.project_restfull_api_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restfull.api.project_restfull_api_crud.entities.Product;
import com.restfull.api.project_restfull_api_crud.respositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true) // Optimización para lectura
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true) // Optimización para lectura
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        // Verificar que el producto existe
        if (productRepository.existsById(id)) {
            product.setId(id); // Asegurar que tenga el ID correcto
            return productRepository.save(product);
        }
        throw new RuntimeException("Producto con ID " + id + " no encontrado");
    }

    @Override
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Producto con ID " + id + " no encontrado");
        }
    }

}

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

    // Método para obtener todos los productos
    @Override
    @Transactional(readOnly = true) // Optimización para lectura
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Método para obtener un producto por su ID
    @Override
    @Transactional(readOnly = true) // Optimización para lectura
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    // Método para guardar un producto
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    // Método para eliminar un producto por su ID
    @Override
    public Optional<Product> deleteProduct(Long id) {
        // Verificamos si el producto existe
        Optional<Product> productFind = productRepository.findById(id);

        // Si hay algo dentro del Optional, ejecuta esta acción. Si está vacío, no hagas
        // nada:
        productFind.ifPresent(product -> productRepository.deleteById(product.getId())); // expresion LAMBDA (funcion anonima)
        return productFind;
    }

    // Método para actualizar un producto (todavía no implementado)
    @Override
    public Optional<Product> updateProduct(Long id, Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

}

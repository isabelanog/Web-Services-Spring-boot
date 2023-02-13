package com.web.services.spring.boot.services;

import com.web.services.spring.boot.entities.Product;
import com.web.services.spring.boot.repositories.ProductRepository;
import com.web.services.spring.boot.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product findById (Long id) {
        boolean hasProduct = productRepository.findById(id).isPresent();
            if (!hasProduct) {
                throw new NotFoundException("Product not found");
            }
        return productRepository.findById(id).get();
    }
}

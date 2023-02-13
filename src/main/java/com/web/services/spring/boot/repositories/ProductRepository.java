package com.web.services.spring.boot.repositories;

import com.web.services.spring.boot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
